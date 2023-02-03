package br.com.sscode.aluvery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.sampledata.sampleProducts
import br.com.sscode.aluvery.sampledata.sampleSections
import br.com.sscode.aluvery.ui.components.CardProductItem
import br.com.sscode.aluvery.ui.components.ProductSection
import br.com.sscode.aluvery.ui.components.SearchTextField
import br.com.sscode.aluvery.ui.theme.AluveryTheme

class HomeScreenUiState(searchText: String = "") {
    var text by mutableStateOf(searchText)
        private set

    val searchedProducts
        get() = if (text.isNotBlank()) {
            sampleProducts.filter { product ->
                product.name.contains(
                    text,
                    ignoreCase = true,
                ) || product.description?.contains(
                    text,
                    ignoreCase = true,
                ) ?: false
            }
        } else emptyList()

    fun isShowSections(): Boolean = text.isBlank()

    val onSearchChange: (String) -> Unit = {
        text = it
    }
}

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {

        SearchTextField(
            searchText = state.text,
            onTextChanged = state.onSearchChange
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp),
            contentPadding = PaddingValues(
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        ) {
            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(state.searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}
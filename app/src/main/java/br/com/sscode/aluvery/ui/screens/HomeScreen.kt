package br.com.sscode.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.sampledata.sampleCandies
import br.com.sscode.aluvery.sampledata.sampleDrinks
import br.com.sscode.aluvery.sampledata.sampleProducts
import br.com.sscode.aluvery.ui.components.CardProductItem
import br.com.sscode.aluvery.ui.components.ProductSection
import br.com.sscode.aluvery.ui.components.SearchTextField
import br.com.sscode.aluvery.ui.theme.AluveryTheme

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    var searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {

    fun isShowSections(): Boolean = searchText.isBlank()
}

@Composable
fun HomeScreen(
    products: List<Product>
) {
    val sections = mapOf(
        "Todos produtos" to products,
        "Promoções" to sampleDrinks + sampleCandies,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )

    var text by rememberSaveable {
        mutableStateOf("")
    }

    fun containsInNameOrDescription() = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    products.filter(containsInNameOrDescription())

        } else emptyList()
    }

    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
    }

    HomeScreen(state = state)
}

@Composable
private fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {

        SearchTextField(
            searchText = state.searchText,
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
                for (section in state.sections) {
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
            HomeScreen(products = sampleProducts)
        }
    }
}
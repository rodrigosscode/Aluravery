package br.com.sscode.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.sscode.aluvery.sampledata.sampleCandies
import br.com.sscode.aluvery.sampledata.sampleDrinks
import br.com.sscode.aluvery.sampledata.sampleProducts
import br.com.sscode.aluvery.ui.components.CardProductItem
import br.com.sscode.aluvery.ui.components.ProductSection
import br.com.sscode.aluvery.ui.components.SearchTextField
import br.com.sscode.aluvery.ui.states.HomeScreenUiState
import br.com.sscode.aluvery.ui.theme.AluveryTheme
import br.com.sscode.aluvery.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}

@Composable
fun HomeScreen(
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
            HomeScreen(
                state = HomeScreenUiState(
                    sections = mapOf(
                        "Todos produtos" to sampleProducts,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    ),
                    onSearchChange = {},
                )
            )
        }
    }
}
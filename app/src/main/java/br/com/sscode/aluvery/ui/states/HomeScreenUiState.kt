package br.com.sscode.aluvery.ui.states

import br.com.sscode.aluvery.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    var searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {

    fun isShowSections(): Boolean = searchText.isBlank()
}
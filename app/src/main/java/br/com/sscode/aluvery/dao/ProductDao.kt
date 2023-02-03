package br.com.sscode.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf(*sampleProducts.toTypedArray())
    }

    fun getAll() = products.toList()

    fun save(product: Product) = products.add(product)
}
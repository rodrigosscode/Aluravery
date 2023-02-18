package br.com.sscode.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.sscode.aluvery.dao.ProductDao
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.ui.states.ProductFormScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenViewModel : ViewModel() {

    private val productDao = ProductDao()

    private val _uiState: MutableStateFlow<ProductFormScreenUiState> = MutableStateFlow(
        ProductFormScreenUiState()
    )
    val uiState: StateFlow<ProductFormScreenUiState> get() = _uiState.asStateFlow()

    private val priceFormatter = DecimalFormat("#.##")

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
                onPriceChange = {
                    val price = try {
                        priceFormatter.format(BigDecimal(it))
                    } catch (e: IllegalArgumentException) {
                        if (it.isEmpty()) {
                            it
                        } else null
                    }

                    price?.let {
                        _uiState.value = _uiState.value.copy(
                            price = price
                        )
                    }
                },
                onDescriptionChange = {
                    _uiState.value = _uiState.value.copy(
                        description = it
                    )
                },
            )
        }
    }

    fun save() {
        _uiState.value.run {

            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }

            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )

            productDao.save(product = product)
        }
    }
}
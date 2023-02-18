package br.com.sscode.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import br.com.sscode.aluvery.ui.screens.ProductFormScreen
import br.com.sscode.aluvery.ui.theme.AluveryTheme
import br.com.sscode.aluvery.ui.viewmodels.ProductFormScreenViewModel

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    val viewModel by viewModels<ProductFormScreenViewModel>()
                    ProductFormScreen(viewModel, onSaveClick = {
                        finish()
                    })
                }
            }
        }
    }
}
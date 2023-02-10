package br.com.sscode.aluvery.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.sscode.aluvery.R
import br.com.sscode.aluvery.dao.ProductDao
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.ui.screens.ProductFormScreen
import br.com.sscode.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormActivity : ComponentActivity() {

    private val productDao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen(onSaveClick = { product ->
                        productDao.save(product)
                        finish()
                    })
                }
            }
        }
    }
}
package br.com.sscode.aluvery

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.sscode.aluvery.dao.ProductDao
import br.com.sscode.aluvery.sampledata.sampleCandies
import br.com.sscode.aluvery.sampledata.sampleDrinks
import br.com.sscode.aluvery.sampledata.sampleSections
import br.com.sscode.aluvery.ui.activities.ProductFormActivity
import br.com.sscode.aluvery.ui.screens.HomeScreen
import br.com.sscode.aluvery.ui.screens.HomeScreenUiState
import br.com.sscode.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val productDao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }, content = {
                val sections = mapOf(
                    "Todos produtos" to productDao.getAll(),
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )
                val state = remember { HomeScreenUiState() }
                HomeScreen(sections = sections, state = state)
            })
        }
    }
}

@Composable
private fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) = AluveryTheme {
    Surface {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick =  onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                content()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App {
       HomeScreen(sections = sampleSections)
    }
}
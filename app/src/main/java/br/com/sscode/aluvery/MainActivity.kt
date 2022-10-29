package br.com.sscode.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import br.com.sscode.aluvery.sampledata.sampleSections
import br.com.sscode.aluvery.ui.screens.HomeScreen
import br.com.sscode.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
private fun App() = AluveryTheme {
    Surface {
        HomeScreen(
            sampleSections
        )
    }
}
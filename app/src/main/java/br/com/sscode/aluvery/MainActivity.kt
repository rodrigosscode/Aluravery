package br.com.sscode.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.sscode.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    MyFirstComposable()
                }
            }
        }
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "Meu primeiro texto")
    Text(text = "Meu segundo texto maior")
}

@Preview(
    name = "DarkTextPreview",
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "OtherTextPreview",
)
@Preview(
    showBackground = true,
    name = "TextPreview",
    widthDp = 200,
    heightDp = 200,
    backgroundColor = 0xFFFF1144
)
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }
}
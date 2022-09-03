package br.com.sscode.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.sscode.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItem() = Column {
    Box(
        modifier = Modifier
            .height(50.dp)
            .background(color = Color.Blue)
            .width(50.dp)
    )
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Imagem do produto"
    )
    Text(text = "Texto 1")
    Text(text = "Texto 2")
}

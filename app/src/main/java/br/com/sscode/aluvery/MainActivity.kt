package br.com.sscode.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.sscode.aluvery.extensions.toBrazilianCurrency
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.ui.theme.AluveryTheme
import br.com.sscode.aluvery.ui.theme.Purple500
import br.com.sscode.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() = AluveryTheme {
    Surface {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            ProductSection()
            ProductSection()
            ProductSection()
            Spacer(Modifier)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}

@Composable
fun ProductSection() = Column {
    Text(
        text = "Promoções",
        fontSize = 20.sp,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            ),
        fontWeight = FontWeight(400)
    )
    Row(
        modifier = Modifier
            .padding(
                top = 8.dp
            )
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        ProductItem(
            Product(
                name = "Hamburguer",
                price = BigDecimal("12.99"),
                imageRes = R.drawable.burger
            )
        )
        ProductItem(
            Product(
                name = "Batata Frita",
                price = BigDecimal("7.99"),
                imageRes = R.drawable.fries
            )
        )
        ProductItem(
            Product(
                name = "Pizza",
                price = BigDecimal("19.99"),
                imageRes = R.drawable.pizza
            )
        )
        Spacer(Modifier)
    }
}

@Composable
fun ProductItem(product: Product) = with(product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        elevation = 4.dp,
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Imagem do produto",
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Center),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = price.toBrazilianCurrency(),
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
private fun ProductSectionPreview() {
    ProductSection()
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("14.99"),
            imageRes = R.drawable.ic_launcher_background
        )
    )
}

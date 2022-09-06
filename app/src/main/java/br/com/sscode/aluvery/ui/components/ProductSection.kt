package br.com.sscode.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.sscode.aluvery.R
import br.com.sscode.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection(
    title: String,
    products: List<Product>
) = Column {
    Text(
        text = title,
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
        for (product in products) {
            ProductItem(product = product)
        }
        Spacer(Modifier)
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
private fun ProductSectionPreview() {
    ProductSection(title = "Promoções", products = sampleProducts)
}

val sampleProducts = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        imageRes = R.drawable.burger
    ),
    Product(
        name = "Batata Frita",
        price = BigDecimal("7.99"),
        imageRes = R.drawable.fries
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("19.99"),
        imageRes = R.drawable.pizza
    )
)

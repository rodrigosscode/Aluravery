package br.com.sscode.aluvery.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.sscode.aluvery.model.Product
import br.com.sscode.aluvery.sampledata.sampleProducts

@Composable
fun ProductSection(
    title: String,
    products: List<Product>,
    modifier: Modifier = Modifier
) = Column {
    Text(
        text = title,
        fontSize = 20.sp,
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            ),
        fontWeight = FontWeight(400)
    )
    LazyRow(
        modifier = modifier
            .padding(
                top = 8.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            Spacer(modifier)
            ProductItem(product = product)
            Spacer(modifier)
        }
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
private fun ProductSectionPreview() {
    ProductSection(title = "Promoções", products = sampleProducts)
}

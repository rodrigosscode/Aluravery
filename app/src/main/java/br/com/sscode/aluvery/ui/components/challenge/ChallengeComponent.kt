package br.com.sscode.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Challenge() = Row(
    modifier = Modifier
        .height(80.dp)
        .width(200.dp)
) {
    Box(
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxHeight()
            .fillMaxWidth(0.3f)
    )
    Column {
        Text(
            text = "Test 1", modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(10.dp),
            fontSize = 6.sp
        )
        Text(text = "Test 2", modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            fontSize = 6.sp)
    }
}
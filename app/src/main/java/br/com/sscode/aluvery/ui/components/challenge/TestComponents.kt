package br.com.sscode.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.sscode.aluvery.ui.theme.AluveryTheme

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Column {
        Text(text = "Text 1")
        Text(text = "Text 2")
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "Text 1")
        Text(text = "Text 2")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    Box {
        Text(text = "Text 1")
        Text(text = "Text 2")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomLayoutPreview() = Column(
    Modifier
        .padding(8.dp)
        .background(color = Color.Blue)
        .padding(all = 8.dp)
        .fillMaxWidth()
        .fillMaxHeight()
) {
    Text(text = "Text 1")
    Text(text = "Text 2")
    Row(
        modifier =
        Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(color = Color.Green)
            .fillMaxWidth(1f)
    ) {
        Text(text = "Text 3")
        Text(text = "Text 4")
    }
    Box(
        modifier =
        Modifier
            .padding(8.dp)
            .background(color = Color.Red)
            .padding(8.dp)
    ) {
        Row(
            modifier =
            Modifier
                .padding(8.dp)
                .background(color = Color.Cyan)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Text 5")
            Text(text = "Text 6")
        }
        Column(
            modifier =
            Modifier
                .padding(8.dp)
                .background(color = Color.Yellow)
                .padding(8.dp)
        ) {
            Text(text = "Text 7")
            Text(text = "Text 8")
        }
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "Meu primeiro texto")
    Text(text = "Meu segundo texto maior")
}

@Preview(
    showBackground = true,
    name = "TextPreview",
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
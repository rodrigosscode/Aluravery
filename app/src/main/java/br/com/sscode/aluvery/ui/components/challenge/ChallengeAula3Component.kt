package br.com.sscode.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.sscode.aluvery.ui.theme.Purple200
import br.com.sscode.aluvery.ui.theme.Purple700


@Preview(showBackground = true)
@Composable
fun ChallengeAula3() = Surface(
    modifier = Modifier.padding(6.dp),
    shape = RoundedCornerShape(10.dp),
    elevation = 4.dp
) {
    Row(
        Modifier
            .width(300.dp)
            .height(150.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Purple700, Purple200
                        )
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(75.dp)
                    .offset(x = 40.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Purple200, Purple700
                            )
                        )
                    )

            ) {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(color = Color.Black)
                        .align(Alignment.Center)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .width(40.dp)
                .fillMaxHeight()
        )
        Column(
            modifier = Modifier
                .padding(25.dp)
        ) {
            Text(
                text = LoremIpsum(30).values.first(),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
package ui

import Corporative_Colors.White
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun QubooWidget() {
    Box(modifier = Modifier
        .padding(42.dp)
        .size(width = 200.dp, height = 100.dp)
        .shadow(5.dp, RoundedCornerShape(15.dp))
        .background(White)
    ){

    }
}
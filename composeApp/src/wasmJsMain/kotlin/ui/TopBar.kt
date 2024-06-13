package ui

import Corporative_Colors.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.*


val gradientBrush = Brush.linearGradient(
    colors = listOf(QubooPrimary, QubooSecondary, QubooTerciary)
)

@Composable
fun TopBar() {
    BoxWithConstraints {
        val isPortrait = maxWidth < maxHeight

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .clip(RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
                .background(gradientBrush)
        ) {
            // Content inside TopBar
        }
    }
}
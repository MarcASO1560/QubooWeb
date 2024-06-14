package ui

import Corporative_Colors.QubooPrimary
import Corporative_Colors.QubooSecondary
import Corporative_Colors.QubooTerciary
import Corporative_Colors.White
import SideBarBool
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

val gradientBrushVertical = Brush.verticalGradient(
    colors = listOf(QubooPrimary, QubooSecondary, QubooTerciary)
)
@Composable
fun SideBar(
) {
    Box(modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.CenterEnd)){
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(200.dp)
            .clip(shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
            .background(gradientBrushVertical)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.TopCenter)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .wrapContentSize(align = Alignment.CenterStart)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .padding(start = 8.dp)
                            .shadow(4.dp, RoundedCornerShape(8.dp))
                            .background(White)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { SideBarBool.value = false }
                            .padding(vertical = 8.dp, horizontal = 12.dp)
                    ){
                        Icon(
                            modifier = Modifier
                                .align(Alignment.Center),
                            imageVector = Icons.Default.Close,
                            contentDescription = "Menu",
                            tint = QubooPrimary
                        )
                    }
                }
            }
        }
    }
}
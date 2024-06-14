import Corporative_Colors.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.states.WebStates

val gradientBrush = Brush.linearGradient(
    colors = listOf(QubooPrimary, QubooSecondary, QubooTerciary)
)

@Composable
fun TopBar(onNavigationSelected: (WebStates) -> Unit) {
    BoxWithConstraints {
        if (maxWidth < maxHeight) {
            // Mostrar botón de menú
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(gradientBrush)
                    .wrapContentSize(align = Alignment.CenterEnd)
            ) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .padding(end = 8.dp)
                        .shadow(4.dp, RoundedCornerShape(8.dp))
                        .background(White)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { SideBarBool.value = true }
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                ){
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center),
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = QubooPrimary
                    )
                }
            }
        } else {
            // Mostrar barra de navegación completa
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .background(gradientBrush)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    WebStates.entries.forEach { state ->
                        Box(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(end = 8.dp)
                                .shadow(4.dp, RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { onNavigationSelected(state) }
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.wrapContentSize(align = Alignment.Center),
                                    imageVector = state.stateIcon,
                                    contentDescription = state.stateName,
                                    tint = QubooPrimary
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    modifier = Modifier
                                        .padding(bottom = 2.dp)
                                        .wrapContentSize(align = Alignment.Center),
                                    text = state.stateName,
                                    color = QubooPrimary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

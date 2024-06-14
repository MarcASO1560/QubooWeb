import Corporative_Colors.*
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.SideBar
import ui.screens.*
import ui.states.*

@Composable
@Preview
fun ContentUi() {
    var currentScreen by remember { mutableStateOf(WebStates.HOME) }
    var targetScreen by remember { mutableStateOf(currentScreen) }

    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(
                    align = Alignment.TopCenter
                )
        ) {
            AnimatedContent(currentState = currentScreen, targetState = targetScreen) { screen ->
                when (screen) {
                    WebStates.GAMES -> GamesScreen()
                    WebStates.HOME -> HomeScreen()
                    WebStates.ABOUT -> AboutScreen()
                }
                currentScreen = targetScreen
            }
            TopBar(onNavigationSelected = { screen ->
                targetScreen = screen
            })
            if (SideBarBool.value) {
                OpaqueScreen()
                SideBar()
            }
        }
    }
}

val gradientBrushTransparent = Brush.linearGradient(
    colors = listOf(QubooPrimaryTransparent, QubooSecondaryTransparent, QubooTerciaryTransparent)
)
@Composable
fun OpaqueScreen(){
    Box(
        modifier = Modifier
            .background(gradientBrushTransparent)
            .fillMaxSize()
            .clickable(
                onClick = {
                    SideBarBool.value = false
                },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    )
}

@Composable
fun AnimatedContent(
    currentState: WebStates,
    targetState: WebStates,
    content: @Composable (WebStates) -> Unit
) {
    val initialOffsetX: (Int) -> Int = { fullWidth ->
        if (targetState.ordinal > currentState.ordinal) fullWidth else -fullWidth
    }
    val targetOffsetX: (Int) -> Int = { fullWidth ->
        if (targetState.ordinal > currentState.ordinal) -fullWidth else fullWidth
    }

    AnimatedContent(
        targetState = targetState,
        transitionSpec = {
            slideInHorizontally(initialOffsetX = initialOffsetX) togetherWith
                    slideOutHorizontally(targetOffsetX = targetOffsetX)
        }
    ) { target ->
        content(target)
    }
}

val SideBarBool = mutableStateOf(false)
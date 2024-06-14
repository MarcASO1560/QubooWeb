package ui.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class WebStates(
    val stateName: String,
    val stateIcon: ImageVector
) {
    GAMES("GAMES", Icons.Filled.SportsEsports),
    HOME("HOME", Icons.Filled.Home),
    ABOUT("ABOUT", Icons.Filled.Groups)
}
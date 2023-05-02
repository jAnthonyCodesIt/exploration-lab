package japractice.android.myfavebites.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notes
import androidx.compose.material.icons.outlined.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String
) {
    object Recipes: BottomMenuData(
        icon = Icons.Outlined.Notes,
        title = "Recipes"
    )
    object Gallery: BottomMenuData(
        icon = Icons.Outlined.PhotoLibrary,
        title  = "Recipe Gallery"
    )
}
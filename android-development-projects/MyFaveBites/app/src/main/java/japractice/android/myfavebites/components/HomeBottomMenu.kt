package japractice.android.myfavebites.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import japractice.android.myfavebites.R
import japractice.android.myfavebites.model.BottomMenuData
import androidx.compose.ui.Modifier

@Composable
fun HomeBottomMenu(navController: NavController) {
    val homeActivities = listOf(
        BottomMenuData.Recipes, BottomMenuData.Gallery
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background, contentColor = MaterialTheme.colors.onBackground
    ) {
        homeActivities.forEach {
            BottomNavigationItem(label = { Text(it.title) }, alwaysShowLabel = true, selected = false, onClick = {
                navController.navigate(
                    // TODO: Make sure this doesn't break the whole app
                    if (it.title == "Recipe Gallery") "RecipeGallery" else "FaveBitesList"
                )
            }, icon = { Icon(imageVector = it.icon, contentDescription = it.title) })
        }
    }
}
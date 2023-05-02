package japractice.android.myfavebites.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import japractice.android.myfavebites.model.BottomMenuData

@Composable
fun HomeBottomMenu() {
    val homeActivities = listOf(
        BottomMenuData.Recipes,
        BottomMenuData.Gallery
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        homeActivities.forEach {
            BottomNavigationItem(
                label = { Text(it.title) },
                alwaysShowLabel = true,
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) }
            )
        }
    }
}
package udemy.android.gmailclone.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import udemy.android.gmailclone.model.BottomMenuData

@Composable
fun HomeBottomMenu() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet,
        BottomMenuData.Note
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        items.forEach {
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
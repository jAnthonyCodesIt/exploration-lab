package udemy.android.newsapp.ui

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuScreen(val route: String, val icon: ImageVector, val title: String) {
    object TopNews: BottomMenuScreen("top_news", Icons.Outlined.Home, "Top News")
    object Categories: BottomMenuScreen("categories", Icons.Outlined.Category, "Categories")
    object Sources: BottomMenuScreen("sources", Icons.Outlined.Newspaper, "Sources")
}
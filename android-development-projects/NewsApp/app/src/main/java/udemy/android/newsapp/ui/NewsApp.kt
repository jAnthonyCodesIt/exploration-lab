package udemy.android.newsapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import udemy.android.newsapp.MockData
import udemy.android.newsapp.components.BottomMenu
import udemy.android.newsapp.ui.screen.Categories
import udemy.android.newsapp.ui.screen.DetailScreen
import udemy.android.newsapp.ui.screen.Sources
import udemy.android.newsapp.ui.screen.TopNews

@Composable
fun NewsApp() {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    MainScreen(navController, scrollState)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, scrollState: ScrollState) {
    Scaffold(
        bottomBar = {
            BottomMenu(navController)
        },
    ) {
        Navigation(navController, scrollState)
    }
}

@Composable
fun Navigation(navController: NavHostController, scrollState: ScrollState) {
    NavHost(navController, startDestination = BottomMenuScreen.TopNews.route) {
        bottomNavigation(navController)
        //NOTE: This seems like duplication since it is in bottomNavigation.
        composable(BottomMenuScreen.TopNews.route) {
            TopNews(navController)
        }
        composable("Detail/{newsId}",
            arguments = listOf(navArgument("newsId"){type = NavType.IntType})){
            navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("newsId")
            val newsData = MockData.getNews(id)
            DetailScreen(scrollState, navController, newsData)
        }

    }
}

fun NavGraphBuilder.bottomNavigation(navController: NavHostController) {
    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController)
    }
    composable(BottomMenuScreen.Categories.route){
        Categories()
    }
    composable(BottomMenuScreen.Sources.route){
        Sources()
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}
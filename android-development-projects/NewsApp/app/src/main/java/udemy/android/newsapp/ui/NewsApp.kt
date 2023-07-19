package udemy.android.newsapp.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import udemy.android.newsapp.MockData
import udemy.android.newsapp.components.BottomMenu
import udemy.android.newsapp.models.TopNewsArticle
import udemy.android.newsapp.network.NewsManager
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
        Navigation(navController, scrollState, paddingValues = it)
    }
}

@Composable
fun Navigation(navController: NavHostController, scrollState: ScrollState, newsManager: NewsManager = NewsManager(), paddingValues: PaddingValues) {
    val articles = newsManager.newsResponse.value.articles
    Log.d("news", "$articles")
    articles?.let {
        NavHost(navController, startDestination = BottomMenuScreen.TopNews.route, Modifier.padding(paddingValues)) {
            bottomNavigation(navController, articles, newsManager)
            composable("Detail/{index}",
                arguments = listOf(navArgument("index"){type = NavType.IntType})){
                    navBackStackEntry ->
                val index = navBackStackEntry.arguments?.getInt("index")
                index?.let {
                    val article = articles[index]
                    DetailScreen(scrollState, navController, article)
                }
            }

        }
    }

}

fun NavGraphBuilder.bottomNavigation(navController: NavHostController, articles: List<TopNewsArticle>, newsManager: NewsManager) {
    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController, articles, newsManager.query, newsManager)
    }
    composable(BottomMenuScreen.Categories.route){
        newsManager.getArticlesByCategory("Business")
        newsManager.onSelectedCategoryChanged("Business")
        Categories(newsManager = newsManager, onFetchCategory = {
            newsManager.onSelectedCategoryChanged(it)
            newsManager.getArticlesByCategory(it)
        })
    }
    composable(BottomMenuScreen.Sources.route){
        Sources(newsManager = newsManager)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}
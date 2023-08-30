package udemy.android.newsapp.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import udemy.android.newsapp.ui.components.BottomMenu
import udemy.android.newsapp.models.TopNewsArticle
import udemy.android.newsapp.ui.screen.Categories
import udemy.android.newsapp.ui.screen.DetailScreen
import udemy.android.newsapp.ui.screen.Sources
import udemy.android.newsapp.ui.screen.TopNews

@Composable
fun NewsApp(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    MainScreen(navController, scrollState, viewModel)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, scrollState: ScrollState, viewModel: MainViewModel) {
    Scaffold(
        bottomBar = {
            BottomMenu(navController)
        },
    ) {
        Navigation(navController, scrollState, paddingValues = it, viewModel = viewModel)
    }
}

@Composable
fun Navigation(
    navController: NavHostController,
    scrollState: ScrollState,
    paddingValues: PaddingValues,
    viewModel: MainViewModel
) {
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.isError.collectAsState()
    val articles = mutableListOf<TopNewsArticle>()
    articles.addAll(viewModel.newsResponse.collectAsState().value.articles ?: listOf(TopNewsArticle()))
    Log.d("news", "$articles")
    articles?.let {
        NavHost(navController, startDestination = BottomMenuScreen.TopNews.route, Modifier.padding(paddingValues)) {
            val queryState = mutableStateOf(viewModel.query.value)
            val isLoading = mutableStateOf(loading)
            val isError = mutableStateOf(error)
            bottomNavigation(navController, articles, queryState, viewModel, isLoading, isError)
            composable("Detail/{index}",
                arguments = listOf(navArgument("index") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val index = navBackStackEntry.arguments?.getInt("index")
                index?.let {
                    if (queryState.value.isNotEmpty()) {
                        articles.clear()
                        articles.addAll(viewModel.searchedNewsResponse.collectAsState().value.articles ?: listOf())
                    } else {
                        articles.clear()
                        articles.addAll(viewModel.newsResponse.collectAsState().value.articles ?: listOf())
                    }
                    val article = articles[index]
                    DetailScreen(scrollState, navController, article)
                }
            }

        }
    }

}

fun NavGraphBuilder.bottomNavigation(
    navController: NavHostController,
    articles: List<TopNewsArticle>,
    query: MutableState<String>,
    viewModel: MainViewModel,
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>
) {
    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController, articles, query, viewModel, isLoading, isError)
    }
    composable(BottomMenuScreen.Categories.route) {
        viewModel.getArticlesByCategory("Business")
        viewModel.onSelectedCategoryChanged("Business")
        Categories(viewModel = viewModel, onFetchCategory = {
            viewModel.onSelectedCategoryChanged(it)
            viewModel.getArticlesByCategory(it)
        }, isLoading = isLoading, isError = isError)
    }
    composable(BottomMenuScreen.Sources.route) {
        Sources(viewModel = viewModel, isLoading = isLoading, isError = isError)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp(viewModel())
}
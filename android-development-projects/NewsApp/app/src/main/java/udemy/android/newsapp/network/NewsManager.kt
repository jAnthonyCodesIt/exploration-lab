package udemy.android.newsapp.network

import android.util.Log
import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import udemy.android.newsapp.models.ArticleCategory
import udemy.android.newsapp.models.TopNewsResponse

class NewsManager(private val service: NewsService) {

    private val _newsResponse = mutableStateOf(TopNewsResponse())
    val newsResponse: State<TopNewsResponse>
        @Composable get() = remember {
            _newsResponse
        }

    val sourceName = mutableStateOf("abc-news");


    private val _getArticleBySource = mutableStateOf(TopNewsResponse())
    val getArticleBySource: State<TopNewsResponse>
        @Composable get() = remember {
            _getArticleBySource
        }

    val query = mutableStateOf("")

    private val _searchedNewsResponse = mutableStateOf(TopNewsResponse())
    val searchedNewsResponse: State<TopNewsResponse>
        @Composable get() = remember {
            _searchedNewsResponse
        }

    val selectedCategory: MutableState<ArticleCategory?> = mutableStateOf(null)

    suspend fun getArticles(country: String): TopNewsResponse = withContext(Dispatchers.IO) {
        service.getTopNews(country)
    }

    suspend fun getArticlesByCategory(category: String, country: String = "us"): TopNewsResponse =
        withContext(Dispatchers.IO) {
            service.getArticlesByCategory(category = category, country = country)
        }

    suspend fun getArticlesBySource(source: String) : TopNewsResponse = withContext(Dispatchers.IO) {
        service.getArticlesBySources(source = source)
    }

    suspend fun getSearchedArticles(query: String) : TopNewsResponse = withContext(Dispatchers.IO) {
        service.getArticles(query = query)
    }
}
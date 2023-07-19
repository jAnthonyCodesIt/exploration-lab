package udemy.android.newsapp.network

import android.content.res.Resources
import android.util.Log
import androidx.compose.runtime.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import udemy.android.newsapp.R
import udemy.android.newsapp.models.ArticleCategory
import udemy.android.newsapp.models.Source
import udemy.android.newsapp.models.TopNewsResponse
import udemy.android.newsapp.models.getArticleCategory

class NewsManager {

    private val _newsResponse = mutableStateOf(TopNewsResponse())
    val newsResponse: State<TopNewsResponse>
        @Composable get() = remember {
            _newsResponse
        }

    val sourceName = mutableStateOf("abc-news");

    private val _getArticleByCategory = mutableStateOf(TopNewsResponse())
    val getArticleByCategory: State<TopNewsResponse>
        @Composable get() = remember {
            _getArticleByCategory
        }

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

    val selectedCategory : MutableState<ArticleCategory?> = mutableStateOf(null)

    init {
        getArticles()
    }

    private fun getArticles() {
        val service = Api.retrofitService
            .getTopNews("US")
        service.enqueue(object : Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if (response.isSuccessful) {
                    _newsResponse.value = response.body()!!
                    Log.d("news", "${_newsResponse.value}")
                } else {
                    Log.d("error", "${response.errorBody()}")
                }
            }
            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", "${t.printStackTrace()}")
            }
        })
    }

    fun getArticlesByCategory(category: String) {
        val service = Api.retrofitService.getArticlesByCategory("US",category)
        service.enqueue(object : Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if (response.isSuccessful) {
                    _getArticleByCategory.value = response.body()!!
                    Log.d("news", "${_getArticleByCategory.value}")
                } else {
                    Log.d("error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", "${t.message}")
            }
        })
    }

    fun onSelectedCategoryChanged(category: String) {
        val newCategory = getArticleCategory(category)
        selectedCategory.value = newCategory

    }

    fun getArticlesBySource() {
        val service = Api.retrofitService.getArticlesBySources(sourceName.value)
        service.enqueue(object : Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if (response.isSuccessful) {
                    _getArticleBySource.value = response.body()!!
                    Log.d("news", "${_getArticleBySource.value}")
                } else {
                    Log.d("error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", "${t.message}")
            }
        })
    }

    fun getSearchedArticles(query: String) {
        val service = Api.retrofitService.getArticles(query)
        service.enqueue(object : Callback<TopNewsResponse> {
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if (response.isSuccessful) {
                    _searchedNewsResponse.value = response.body()!!
                    Log.d("search", "${_searchedNewsResponse.value}")
                } else {
                    Log.d("search-error", "${response.code()}")
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("search-error", "${t.message}")
            }
        })
    }
}
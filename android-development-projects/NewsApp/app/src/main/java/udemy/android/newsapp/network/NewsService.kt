package udemy.android.newsapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import udemy.android.newsapp.models.TopNewsResponse

interface NewsService {
    @GET("top-headlines")
    suspend fun getTopNews(@Query("country") country: String): TopNewsResponse

    @GET("top-headlines")
    suspend fun getArticlesByCategory(@Query("country") country: String, @Query("category") category: String): TopNewsResponse

    @GET("everything")
    suspend fun getArticlesBySources(@Query("sources") source: String): TopNewsResponse

    @GET("everything")
    suspend fun getArticles(@Query("q") query: String): TopNewsResponse
}
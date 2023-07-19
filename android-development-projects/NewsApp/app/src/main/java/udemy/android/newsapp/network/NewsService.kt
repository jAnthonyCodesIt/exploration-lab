package udemy.android.newsapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import udemy.android.newsapp.models.TopNewsResponse

interface NewsService {
    @GET("top-headlines")
    fun getTopNews(@Query("country") country: String): Call<TopNewsResponse>

    @GET("top-headlines")
    fun getArticlesByCategory(@Query("country") country: String, @Query("category") category: String): Call<TopNewsResponse>

    @GET("everything")
    fun getArticlesBySources(@Query("sources") source: String): Call<TopNewsResponse>

    @GET("everything")
    fun getArticles(@Query("q") query: String): Call<TopNewsResponse>
}
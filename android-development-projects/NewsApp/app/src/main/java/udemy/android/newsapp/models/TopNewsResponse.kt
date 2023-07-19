package udemy.android.newsapp.models

data class TopNewsResponse(
    val status : String? = null,
    val totalResuults : Int? = null,
    val articles : List<TopNewsArticle>? = null
)

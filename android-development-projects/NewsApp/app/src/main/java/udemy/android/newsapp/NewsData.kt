package udemy.android.newsapp

data class NewsData(
    val id:Int,
    val image:Int = R.drawable.breakingnews_anime,
    val author:String,
    val title:String,
    val description:String,
    val publishedAt:String
)
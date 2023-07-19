package udemy.android.newsapp.models

import udemy.android.newsapp.models.ArticleCategory.*

enum class ArticleCategory(val categoryName: String) {
    BUSINESS("Business"),
    ENTERTAINMENT("Entertainment"),
    GENERAL("General"),
    HEALTH("Health"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    TECHNOLOGY("Technology")
}

fun getAllArticleCategories(): List<ArticleCategory> = listOf(
    ArticleCategory.BUSINESS,
    ArticleCategory.ENTERTAINMENT,
    ArticleCategory.GENERAL,
    ArticleCategory.HEALTH,
    ArticleCategory.SCIENCE,
    ArticleCategory.SPORTS,
    ArticleCategory.TECHNOLOGY
)

fun getArticleCategory(category: String) : ArticleCategory? {
    val map = values().associateBy(ArticleCategory::categoryName)
    return map[category]
}
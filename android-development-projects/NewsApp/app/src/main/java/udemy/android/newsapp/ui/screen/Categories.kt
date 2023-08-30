package udemy.android.newsapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import udemy.android.newsapp.MockData
import udemy.android.newsapp.MockData.getTimeAgo
import udemy.android.newsapp.R
import udemy.android.newsapp.models.TopNewsArticle
import udemy.android.newsapp.models.getAllArticleCategories
import udemy.android.newsapp.ui.MainViewModel
import udemy.android.newsapp.ui.components.ErrorUI
import udemy.android.newsapp.ui.components.LoadingUI

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun Categories(
    onFetchCategory: (String) -> Unit = {},
    viewModel: MainViewModel,
    isLoading: MutableState<Boolean>,
    isError: MutableState<Boolean>
) {
    val tabsItems = getAllArticleCategories()
    Column {
        when {
            isLoading.value -> {
                LoadingUI()
            }

            isError.value -> {
                ErrorUI()
            }

            else -> {
                LazyRow {
                    items(tabsItems.size) {
                        val category = tabsItems[it]
                        CategoryTab(
                            category.categoryName,
                            onFetchCategory = onFetchCategory,
                            isSelected = viewModel.selectedCategory.collectAsState().value == category
                        )
                    }
                }
            }
        }

        ArticleContent(articles = viewModel.getArticleByCategory.collectAsState().value.articles ?: listOf())
    }
}

@Composable
fun CategoryTab(category: String, isSelected: Boolean = false, onFetchCategory: (String) -> Unit) {
    val background = if (isSelected) colorResource(R.color.purple_200) else colorResource(R.color.purple_700)
    Surface(
        modifier = Modifier.padding(4.dp, 16.dp).clickable {
            onFetchCategory(category)
        }, shape = MaterialTheme.shapes.small, color = background
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.body2,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ArticleContent(articles: List<TopNewsArticle>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(articles) { article ->
            Card(
                modifier.padding(8.dp), border = BorderStroke(2.dp, color = colorResource(R.color.purple_500))
            ) {
                Row(modifier.fillMaxWidth().padding(8.dp)) {
                    CoilImage(
                        imageModel = article.urlToImage,
                        modifier = Modifier.size(100.dp),
                        placeHolder = painterResource(R.drawable.breaking_news),
                        error = painterResource(R.drawable.breaking_news)
                    )
                    Column(modifier.padding(8.dp)) {
                        Text(
                            text = article.title ?: "Not Available",
                            fontWeight = FontWeight.Bold,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(
                            modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = article.author ?: "Not Available")
                            Text(
                                text = MockData.stringToDate(article.publishedAt ?: "2023-05-15T09:35:21Z").getTimeAgo()
                            )
                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun ArticleCategoryPreview() {
    ArticleContent(
        articles = listOf(
            TopNewsArticle(
                author = "Robin, Straw Hat News",
                title = "Luffy, Finally! King of the Pirates!",
                description = "Luffy, after many trials and tribulations, has achieved his life long goal of becoming King of the Pirates! The Straw Hats are on top of the world!",
                publishedAt = "2023-05-15T09:35:21Z"
            )
        )
    )
}
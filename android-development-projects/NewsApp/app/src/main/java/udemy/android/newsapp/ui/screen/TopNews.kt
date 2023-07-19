package udemy.android.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.coil.CoilImage
import udemy.android.newsapp.MockData
import udemy.android.newsapp.MockData.getTimeAgo
import udemy.android.newsapp.NewsData
import udemy.android.newsapp.R
import udemy.android.newsapp.models.TopNewsArticle
import udemy.android.newsapp.network.NewsManager
import udemy.android.newsapp.ui.components.SearchBar

@Composable
fun TopNews(navController: NavController, articles: List<TopNewsArticle>, query: MutableState<String>, newsManager: NewsManager) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text("Top News", fontWeight = FontWeight.SemiBold)
        SearchBar(query = query, newsManager = newsManager)
        LazyColumn {
            items(articles.size) {
                index ->
                TopNewsItem(article = articles[index], onNewsClick = {
                    navController.navigate("Detail/$index")
                })
            }
        }
    }
}

@Composable
fun TopNewsItem(article: TopNewsArticle, onNewsClick: ()-> Unit = {}) {
    Box(modifier = Modifier
        .height(200.dp)
        .padding(8.dp)
        .clickable {
            onNewsClick()
        }
    ) {
        CoilImage(
            imageModel = article.urlToImage,
            contentScale = ContentScale.Crop,
            error = ImageBitmap.imageResource(id = R.drawable.breaking_news),
            placeHolder = ImageBitmap.imageResource(id = R.drawable.breaking_news)
        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
            ) {
            Text(
                text = MockData.stringToDate(article.publishedAt!!).getTimeAgo(),
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(80.dp))
            Text(
                text = article.title!!,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopNewsPreview() {
//    TopNews(rememberNavController())
    TopNewsItem(
        TopNewsArticle(
        author = "Mary Jane Watson, Daily Bugle",
        title = "BREAKING NEWS! Araneus saves the Multiverse!!!",
        description = "After a clash of worlds, the heroes of Earth 2112 were able to mend the multiverse and Spider-Hero Araneus was at the center of it all. In a flash of lightning, he faced the danger of absolute oblivion in the face, mending the mega-rift of space and time.",
        publishedAt = "2023-05-17T08:35:21Z")
    )
}
package udemy.android.newsapp.ui.screen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.coil.CoilImage
import udemy.android.newsapp.MockData
import udemy.android.newsapp.MockData.getTimeAgo
import udemy.android.newsapp.NewsData
import udemy.android.newsapp.R
import udemy.android.newsapp.models.TopNewsArticle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(scrollState: ScrollState, navController: NavController, article: TopNewsArticle) {
    Scaffold(
        topBar = {
            DetailTopAppBar(onBackPressed = {navController.popBackStack()})
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp).verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Detail Screen", fontWeight = FontWeight.SemiBold)
            CoilImage(
                imageModel = article.urlToImage,
                contentScale = ContentScale.Crop,
                error = ImageBitmap.imageResource(id = R.drawable.breaking_news),
                placeHolder = ImageBitmap.imageResource(id = R.drawable.breaking_news)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoWithIcon(Icons.Default.Edit, article.author?:"Not Available")
                InfoWithIcon(Icons.Default.DateRange, info = MockData.stringToDate(article.publishedAt?:"Unknown").getTimeAgo())
            }
            Text(text = article.title?:"Not Available", fontWeight = FontWeight.Bold)
            Text(text = article.description?:"Not Available", modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun DetailTopAppBar(onBackPressed: ()-> Unit = {}): Unit {
    TopAppBar(title = { Text(text = "Detail Screen", fontWeight = FontWeight.SemiBold) },
        navigationIcon = {
            IconButton(onClick = {onBackPressed()}) {
                Icon(imageVector = Icons.Default.ArrowBack, "")
            }
        })
}

@Composable
fun InfoWithIcon(icon: ImageVector, info: String) {
    Row {
       Icon(icon, contentDescription = "Author",
           modifier = Modifier.padding(end = 8.dp),
           colorResource(R.color.purple_500
           )
       )
       Text(text = info)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        rememberScrollState(),
        rememberNavController(),
        TopNewsArticle(
            author = "Mary Jane Watson, Daily Bugle",
            title = "BREAKING NEWS! Araneus saves the Multiverse!!!",
            description = "After a clash of worlds, the heroes of Earth 2112 were able to mend the multiverse and Spider-Hero Araneus was at the center of it all. In a flash of lightning, he faced the danger of absolute oblivion in the face, mending the mega-rift of space and time.",
            publishedAt = "2023-05-17T08:35:21Z"
        )
    )
}
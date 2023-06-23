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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import udemy.android.newsapp.MockData
import udemy.android.newsapp.MockData.getTimeAgo
import udemy.android.newsapp.NewsData
import udemy.android.newsapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(scrollState: ScrollState, navController: NavController, newsData: NewsData) {
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
            Image(painterResource(id = newsData.image),
                contentDescription = "")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoWithIcon(Icons.Default.Edit, newsData.author)
                InfoWithIcon(Icons.Default.DateRange, info = MockData.stringToDate(newsData.publishedAt).getTimeAgo())
            }
            Text(text = newsData.title, fontWeight = FontWeight.Bold)
            Text(text = newsData.description, modifier = Modifier.padding(top = 16.dp))
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
        NewsData(
            2,
            R.drawable.zorothegreatest,
            author = "Robin, Straw Hat News",
            title = "Zoro⚔️ is the G.O.A.T.🐐, Confirmed",
            description = "Zoro has fully solidified himself as the greatest swordsman to ever live. No one has ever accomplished the feats of this caliber. The Straw Hats couldn't be prouder",
            publishedAt = "2023-05-14T08:35:21Z"
        )
        )
}
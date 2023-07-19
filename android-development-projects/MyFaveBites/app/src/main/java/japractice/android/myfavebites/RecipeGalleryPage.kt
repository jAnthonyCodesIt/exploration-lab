package japractice.android.myfavebites

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import japractice.android.myfavebites.components.FaveBiteItem
import japractice.android.myfavebites.data.MockData
import japractice.android.myfavebites.model.FaveBitesData

@Composable
fun RecipeGalleryPage(paddingValues: PaddingValues, scrollState: ScrollState, navController: NavHostController) {
    // TODO: Figure out how to make this a pretty gallery of the photos
    /* Ideas:
     * A column of cards spaced out evenly
     */
    Box(modifier = Modifier
        .padding(paddingValues),
        contentAlignment = Alignment.Center
        ) {
        LazyColumn(
            Modifier.fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, orientation = Orientation.Vertical)
        ) {
            items(MockData.faveBitesList) {
                    faveBiteData ->
                FaveBiteGalleryItem(faveBiteData) {
                    navController.navigate("RecipeDetailsPage/${faveBiteData.faveBiteId}")
                }
            }
        }
    }
}

@Composable
fun FaveBiteGalleryItem(faveBite: FaveBitesData, onFaveBiteGalleryClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .clickable {
                onFaveBiteGalleryClick()
            }
    ) {
        Card(
            elevation = 12.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(15.dp)
                .height(200.dp)
                .width(250.dp),
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(faveBite.imageIcon),
                    contentDescription = faveBite.recipeName,
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .weight(.8f)
                        .fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = faveBite.recipeName,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FaveBiteGslleryItemPreview() {
    FaveBiteGalleryItem(
        faveBite = FaveBitesData(
            faveBiteId = 1,
            recipeName = "Tostones",
            imageIcon = R.drawable.tostones,
            description = "Tostones are a delicious and crispy Latin American treat made from fried green " +
                    "plantains. They offer a savory crunch and are a good source of fiber, vitamins, " +
                    "and minerals, including potassium, making them a guilt-free snack choice.",
            dietType = "Vegetarian",
            cuisine = "Caribbean",
            ingredients = listOf(
                "Plantains",
                "Olive oil",
                "Water",
                "Salt"
            ),
            prepTime = "10:00",
            skillLevel = "Low"
        )
    )
}
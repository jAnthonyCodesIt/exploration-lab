package japractice.android.myfavebites.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import japractice.android.myfavebites.R
import japractice.android.myfavebites.data.MockData.faveBitesList
import japractice.android.myfavebites.model.FaveBitesData

@Composable
fun FaveBitesList(paddingValues: PaddingValues, scrollState: ScrollState, navController: NavController) {
    Box(Modifier.padding(paddingValues)) {
        LazyColumn(
            Modifier.fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, orientation = Vertical)
        ) {
            items(faveBitesList) {
                faveBiteData ->
                FaveBiteItem(faveBiteData) {
                    navController.navigate("RecipeDetailsPage/${faveBiteData.faveBiteId}")
                }
            }
        }
    }
}

// TODO Figure out why sizing isn't exactly right
@Composable
fun FaveBiteItem(faveBitesData: FaveBitesData, modifier: Modifier = Modifier, onFaveBiteClick: ()-> Unit = {}) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable {
                onFaveBiteClick()
            }
    ) {
        Card(
            modifier = modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape),
        ) {
            Image(painter = painterResource(faveBitesData.imageIcon) , faveBitesData.description)
        }
        // Fave bite data
        Column(
            modifier.weight(2.0f)
                .fillMaxWidth(2.0f)
                .padding(start = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Recipe Name
            Text(
                text = faveBitesData.recipeName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            // Skill Level text
            // Prep Time text
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Text(
                    text = "Skill level: ${faveBitesData.skillLevel}",
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "Prep Time ${faveBitesData.prepTime}",
                    fontSize = 12.sp
                )
            }
            // TODO Maybe
            // Column
            // Love meter heart icon
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FaveBiteItemPreview() {
    FaveBiteItem(
        faveBitesData = FaveBitesData(
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
package japractice.android.myfavebites

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import japractice.android.myfavebites.model.FaveBitesData
import japractice.android.myfavebites.ui.theme.MyFaveBitesTheme

/*
* Profile for each favorite "Bite"!
* This composable would probably benefit from a data class object representing a recipe as a parameter
* */

@Composable
fun BiteProfilePage(navController: NavController, recipeData: FaveBitesData) {

    // Tracks the number of faves you give this recipe
    var heartsState by remember {
        mutableStateOf(0)
    }
    var hearts by rememberSaveable {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            elevation = 12.dp,
            modifier = Modifier.fillMaxSize()
                .padding(20.dp, 10.dp)
        ) {
            BoxWithConstraints {
                val constraints = if (minWidth < 600.dp) {
                    portraitConstraints(16.dp)
                } else {
                    landscapeConstraints(16.dp)
                }

                ConstraintLayout(constraints) {
                    // Fave Bite image
                    Surface(
                        elevation = 8.dp,
                        color = Color(0xff000000),
                        shape = CircleShape,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(10.dp)
                            .border(
                                width = 3.dp,
                                color = Color(0xff000000),
                                shape = CircleShape,
                            )
                            .layoutId(R.string.recipeImage)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.tostones),
                            contentDescription = "Tostones",
                            modifier = Modifier
                                .clip(CircleShape),
                            contentScale = ContentScale.FillBounds,
                            alignment = Alignment.Center
                        )
                    }
                    // General info
                    Surface(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .layoutId(R.string.recipeTopInfoContainer)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(3.dp),
                            modifier = Modifier
                                .padding(10.dp, 10.dp)

                        ) {
                            Text(
                                text = "Tostones",
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace,
//                            textAlign = TextAlign.Start
                                )
                            ) // Fave Bite name
                            Text(
                                text = "Vegetarian",
                                style = TextStyle(
                                    fontSize = 23.sp,
//                            fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace,
                                    fontStyle = FontStyle.Normal
//                            textAlign = TextAlign.Start
                                )
                            ) // Diet type
                            Text(
                                text = "Caribbean",
                                style = TextStyle(
                                    fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace,
                                    fontStyle = FontStyle.Italic
//                            textAlign = TextAlign.Start
                                )
                            ) // Cuisine
                        }
                    }
                    // Prep time and skill level
                    Surface(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .layoutId(R.string.recipeStatsContainer)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(3.dp),
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxWidth(if (minWidth < 600.dp) 1f else .3f)
//                            .layoutId(R.string.recipeStatsContainer)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .layoutId(R.string.recipePrepTimeContainer)
                                    .fillMaxWidth(1f)
                            ) {
                                Text(
                                    text = "Prep Time:",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold,
//                                    shadow = Shadow(Color.Black, Offset.Zero, 0.8f)
                                    )
                                )  // Prep time label
                                Text(
                                    text = "12 min.",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontStyle = FontStyle.Italic
                                    )
                                )  // Actual Prep time
                            }
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .layoutId(R.string.recipeSkillLevelContainer)
                                    .fillMaxWidth(1f)
                            ) {
                                Text(
                                    text = "Skill Level:",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) // Skill level label
                                Text(
                                    text = "Low",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Monospace,
                                        fontStyle = FontStyle.Italic
                                    )
                                ) // Actual Skill level
                            }
                        }
                    }
                    // Description and Ingredients
                    Surface(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .layoutId(R.string.recipeDescriptionContainer)
                            .fillMaxWidth(if (minWidth < 600.dp) 1f else .75f)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(7.dp),
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp),
                            ) {
                                Text(
                                    text = "Description",
                                    style = TextStyle(
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    ),
                                ) // Description header
                                Text(
                                    text = "Tostones are a delicious and crispy Latin American treat made from fried green " +
                                            "plantains. They offer a savory crunch and are a good source of fiber, vitamins, " +
                                            "and minerals, including potassium, making them a guilt-free snack choice.",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily.Monospace
                                    )
                                ) // Description text
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp),

                                ) {
                                Text(
                                    text = "Ingredients",
                                    style = TextStyle(
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                ) // Ingredients header
                                Text(
                                    text = """
                                 ${"\u2022"} Plantains
                                 ${"\u2022"} Olive oil
                                 ${"\u2022"} Water
                                 ${"\u2022"} Salt
                            """.trimIndent(),
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily.Monospace
                                    )
                                ) // Ingredients list
                            }
                        }

                    }
                    // Love meter/level
                    Surface(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(10.dp)
                            .layoutId(R.string.recipeLoveButtonContainer)
                            .fillMaxWidth(if (minWidth < 600.dp) 1f else .6f)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(1f)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(Icons.Rounded.Favorite, contentDescription = "We love this recipe")
                                Text("$hearts")
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                Button(onClick = {
                                    hearts = ++heartsState
                                }) {
                                    Icon(Icons.Rounded.KeyboardArrowUp, contentDescription = "Add hearts")
                                }
                                Button(onClick = {
                                    hearts = if (heartsState - 0 > 0) --heartsState else heartsState
                                }) {

                                    Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "Delete hearts")
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}

//TODO: This could still use a lot of work. Currently just using the portrait mode looks better even in landscape.
//Figure out how to make everything a bit more dynamic, maybe some if statements for properties of Containers
private fun landscapeConstraints(margin: Dp): ConstraintSet {
//    return portraitConstraints(margin)
    return ConstraintSet {
        val (
            recipeImage, recipeTopInfoContainer, recipeStatsContainer,
            recipeDescriptionContainer, recipeLoveButtonContainer
        ) = listOf(
            createRefFor(R.string.recipeImage),
            createRefFor(R.string.recipeTopInfoContainer),
            createRefFor(R.string.recipeStatsContainer),
            createRefFor(R.string.recipeDescriptionContainer),
            createRefFor(R.string.recipeLoveButtonContainer)
        )
        val guideline1 = createGuidelineFromStart(0.20f)
        val guideline2 = createGuidelineFromStart(0.60f)
        constrain(recipeImage) {
            top.linkTo(parent.top, margin)
            start.linkTo(parent.start, margin)
        }
        constrain(recipeTopInfoContainer) {
            top.linkTo(recipeImage.bottom)
            start.linkTo(parent.start)
            bottom.linkTo(recipeDescriptionContainer.bottom)
        }
        constrain(recipeStatsContainer) {
            top.linkTo(recipeTopInfoContainer.bottom)
            start.linkTo(parent.start)
        }
        constrain(recipeDescriptionContainer) {
            top.linkTo(parent.top)
            start.linkTo(recipeImage.end, margin)
            end.linkTo(parent.end, margin)
        }
        constrain(recipeLoveButtonContainer) {
            top.linkTo(recipeStatsContainer.top)
            bottom.linkTo(recipeStatsContainer.bottom)
            start.linkTo(recipeStatsContainer.end, margin)
        }
    }


}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val (
            recipeImage, recipeTopInfoContainer, recipeStatsContainer,
            recipeDescriptionContainer, recipeLoveButtonContainer
        ) = listOf(
            createRefFor(R.string.recipeImage),
            createRefFor(R.string.recipeTopInfoContainer),
            createRefFor(R.string.recipeStatsContainer),
            createRefFor(R.string.recipeDescriptionContainer),
            createRefFor(R.string.recipeLoveButtonContainer)
        )

        constrain(recipeImage) {
            top.linkTo(parent.top, margin)
            start.linkTo(parent.start, margin)
        }
        constrain(recipeTopInfoContainer) {
            top.linkTo(parent.top, margin)
            start.linkTo(recipeImage.end)
            end.linkTo(recipeStatsContainer.end)
        }
        constrain(recipeStatsContainer) {
            top.linkTo(recipeImage.bottom)
            start.linkTo(parent.start)
        }
        constrain(recipeDescriptionContainer) {
            top.linkTo(recipeStatsContainer.bottom, margin)
            start.linkTo(parent.start)
        }
        constrain(recipeLoveButtonContainer) {
            top.linkTo(recipeDescriptionContainer.bottom, margin)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BiteProfilePreview() {
    MyFaveBitesTheme(true) {
        BiteProfilePage(
            rememberNavController(),
            FaveBitesData(
                faveBiteId = 14,
                recipeName = "Oatmeal Peanut Butter Cookies",
                imageIcon = R.drawable.oatmeal_peanutbutter_cookies,
                skillLevel = "Low",
                prepTime = "25:00",
                description = "Oatmeal peanut butter cookies are crunchy and nutty cookies made from oats, peanut butter, flour, sugar, butter, eggs, baking soda, and salt. " + "They are a satisfying and wholesome treat that can be enjoyed as a snack or dessert. " + "They are also rich in protein, fiber, and healthy fats, and can help lower your cholesterol and blood sugar levels.",
                ingredients = listOf(
                    "Oats",
                    "Peanut butter",
                    "Flour",
                    "Sugar",
                    "Butter",
                    "Eggs",
                    "Baking soda",
                    "Salt"
                )
            )
        )
    }
    MyFaveBitesTheme() {
        BiteProfilePage(
            rememberNavController(),
            FaveBitesData(
                faveBiteId = 14,
                recipeName = "Oatmeal Peanut Butter Cookies",
                imageIcon = R.drawable.oatmeal_peanutbutter_cookies,
                skillLevel = "Low",
                prepTime = "25:00",
                description = "Oatmeal peanut butter cookies are crunchy and nutty cookies made from oats, peanut butter, flour, sugar, butter, eggs, baking soda, and salt. " + "They are a satisfying and wholesome treat that can be enjoyed as a snack or dessert. " + "They are also rich in protein, fiber, and healthy fats, and can help lower your cholesterol and blood sugar levels.",
                ingredients = listOf(
                    "Oats",
                    "Peanut butter",
                    "Flour",
                    "Sugar",
                    "Butter",
                    "Eggs",
                    "Baking soda",
                    "Salt"
                )
            )
        )
    }
}
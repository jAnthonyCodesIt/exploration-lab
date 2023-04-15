package udemy.android.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {
    Card(
        elevation = 6.dp,
        modifier = Modifier.fillMaxSize()
            .padding(16.dp, 10.dp)
            .border(2.dp, Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        // Content of our Card - Profile picture of dog, description, followers, etc
        BoxWithConstraints {
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(16.dp)
            } else {
                //TODO landscapeConstraints
                landscapeConstraints(16.dp)
            }

            ConstraintLayout(constraints) {

                Image(
                    painter = painterResource(id = R.drawable.husky_bolt),
                    contentDescription = "Husky",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Red,
                            shape = CircleShape
                        )
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Siberian Husky",
                    modifier = Modifier.layoutId("nameText")
                )
                Text(
                    text = "Germany",
                    modifier = Modifier.layoutId("countryText")
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")
                ) {
                    ProfileStats("150", "Followers")
                    ProfileStats("100", "Following")
                    ProfileStats("30", "Posts")
                }


                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.layoutId("buttonFollow")
                ) {
                    Text(text = "Follow user")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.layoutId("buttonDirectMessage")
                ) {
                    Text(text = "Direct Message")
                }
            }
        }

    }
}

@Composable
fun ProfileStats(count: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonDirectMessage = createRefFor("buttonDirectMessage")
        val guideLine = createGuidelineFromTop(0.1f)
        constrain(image) {
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText) {
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(countryText) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats) {
            top.linkTo(countryText.bottom)
        }
        constrain(buttonFollow) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(buttonDirectMessage.start)
            width = Dimension.wrapContent
        }
        constrain(buttonDirectMessage) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

private fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonDirectMessage = createRefFor("buttonDirectMessage")
        val guideLine = createGuidelineFromTop(0.1f)

        constrain(image) {
            top.linkTo(guideLine)
            start.linkTo(parent.start, margin = margin)
        }
        constrain(nameText) {
            start.linkTo(image.start)
            end.linkTo(image.end)
            top.linkTo(image.bottom, margin = margin)
        }
        constrain(countryText) {
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStats) {
            top.linkTo(image.top, margin = margin)
            start.linkTo(image.end, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(buttonFollow) {
            top.linkTo(rowStats.bottom)
            start.linkTo(rowStats.start, margin = margin)
            end.linkTo(buttonDirectMessage.start)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
        constrain(buttonDirectMessage) {
            top.linkTo(rowStats.bottom)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}
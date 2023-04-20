package udemy.android.gmailclone.components

import android.app.Dialog
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import udemy.android.gmailclone.GmailApp
import udemy.android.gmailclone.ui.theme.GmailCloneTheme
import udemy.android.gmailclone.R

@Composable
fun HomeAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope, openDialog: MutableState<Boolean>, scrollState: ScrollState) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 6.dp,
            modifier = Modifier
                .requiredHeight(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                IconButton(onClick = {
                    scope.launch{
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(Icons.Default.Menu, "Menu")
                }
                Text("Search in emails . . .", Modifier.weight(2.0f))
                Image(
                    painter = painterResource(id = R.drawable.superdevsatlanta),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                        .clickable {
                            openDialog.value = true
                        }
                )
                if (openDialog.value) {
                    AccountDialog(openDialog)
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    GmailCloneTheme() {
        GmailApp()
    }
}
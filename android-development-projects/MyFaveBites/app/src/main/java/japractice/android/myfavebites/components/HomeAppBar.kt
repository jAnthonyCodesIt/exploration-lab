package japractice.android.myfavebites.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import japractice.android.myfavebites.MyFaveBitesApp
import japractice.android.myfavebites.ui.theme.MyFaveBitesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope,
               openDialog: MutableState<Boolean>, scrollState: ScrollState) {
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
                Text("Search for your fave bites . . .", Modifier.weight(2.0f))
                // Open Dialog would go here when you implement it
                if (openDialog.value) {
                    // Launch Dialog Composable
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeAppBarPreview() {
    MyFaveBitesTheme {
        MyFaveBitesApp()
    }
}
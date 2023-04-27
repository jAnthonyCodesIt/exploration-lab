package japractice.android.myfavebites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import japractice.android.myfavebites.components.*
import japractice.android.myfavebites.ui.theme.MyFaveBitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFaveBitesTheme() {
                // TODO: Not yet implemented. Page to navigate to when a Fave Bite is clicked on
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    BiteProfilePage()
//                }
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Composable
fun MyFaveBitesApp() {
    // States to keep track of UI actions/movement
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    // TODO: Open Dialog will represent a larger bite preview
    val openDialog = remember {
        mutableStateOf(false)
    }

    // Scaffold to hold some of the app features together
    Scaffold(
        scaffoldState = scaffoldState,
        topBar =  {
            HomeAppBar(scaffoldState, coroutineScope, openDialog, scrollState)
        },
        drawerContent = {
            FaveBitesDrawerMenu(scrollState)
        },
        bottomBar = {
            HomeBottomMenu()
        },
        floatingActionButton = {
            FaveBitesFab(scrollState)
        }
    ) {
        FaveBitesList(it, scrollState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFaveBitesTheme() {
//        BiteProfilePage()
        MyFaveBitesApp()
    }
}
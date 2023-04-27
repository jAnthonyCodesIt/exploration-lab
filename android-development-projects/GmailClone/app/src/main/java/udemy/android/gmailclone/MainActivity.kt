package udemy.android.gmailclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import udemy.android.gmailclone.components.*
import udemy.android.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    GmailApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailApp() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDialog = remember {
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope,  openDialog, scrollState) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        },
        bottomBar = {
            HomeBottomMenu()
        },
        floatingActionButton = {
            GmailFab(scrollState)
        }
    ) {
        MailList(it, scrollState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneTheme() {
        GmailApp()
    }
}
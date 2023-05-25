package japractice.android.myfavebites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import japractice.android.myfavebites.components.*
import japractice.android.myfavebites.data.MockData
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
                    MyFaveBitesApp()
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

    val navController = rememberNavController()

    // Scaffold to hold some of the app features together
    Scaffold(
        scaffoldState = scaffoldState,
        topBar =  {
            // DONE
            HomeAppBar(scaffoldState, coroutineScope, openDialog, scrollState)
        },
        drawerContent = {
            // DONE
            FaveBitesDrawerMenu(scrollState)
        },
        bottomBar = {
            // DONE
            HomeBottomMenu(navController)
        },
        floatingActionButton = {
            // TODO Change icon depending on which home screen page you are on
            FaveBitesFab(scrollState)
        }
    ) {
        innerPaddingModifier ->
        NavHost(navController = navController, startDestination = "FaveBitesList") {
            composable("FaveBitesList") {
                FaveBitesList(innerPaddingModifier, scrollState, navController)
            }
            composable("RecipeGallery/{recipeId}",
                arguments = listOf(navArgument("recipeId"){type = NavType.IntType})
            ) {
                navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getInt("recipeId")
                val recipeData = MockData.getRecipes(id)
                RecipeGalleryPage(navController, recipeData)
            }
            composable("RecipeDetailsPage/{recipeId}",
                arguments = listOf(navArgument("recipeId"){type = NavType.IntType})
            ) {
                navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getInt("recipeId")
                val recipeData = MockData.getRecipes(id)
                BiteProfilePage(navController, recipeData)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFaveBitesTheme(true) {
//        BiteProfilePage()
        MyFaveBitesApp()
    }
}
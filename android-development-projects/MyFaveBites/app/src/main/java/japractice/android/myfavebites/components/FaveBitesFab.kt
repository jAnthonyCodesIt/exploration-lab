package japractice.android.myfavebites.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun FaveBitesFab(scrollState: ScrollState) {
    if (scrollState.value > 50) {
        ExtendedFloatingActionButton(
            text = {
                Text(
                    text = "New Bite",
                    fontSize = 16.sp
                )
            },
            onClick = { /*TODO*/},
            backgroundColor = MaterialTheme.colors.surface,
            icon = {
                Icon(Icons.Default.Add, "Add new bite")
            }
        )
    } else {
        FloatingActionButton(
            onClick = {/*TODO*/},
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(Icons.Default.Add, "Add new bite")
            // Use this icon for when you are on gallery screen
//            Icon(Icons.Default.AddToPhotos, "Add new bite")
        }
    }
}
package udemy.android.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(scrollState: ScrollState) {
    if (scrollState.value > 100) {
        ExtendedFloatingActionButton(
            text = {
                Text(
                    text = "Compose",
                    fontSize = 16.sp
                )
            },
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colors.surface,
            icon = {
                Icon(imageVector = Icons.Default.Edit, "Edit")
            }
        )
    } else {
        FloatingActionButton(
            onClick = {/*TODO*/ },
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(imageVector = Icons.Default.Edit, "Edit")
        }
    }
}
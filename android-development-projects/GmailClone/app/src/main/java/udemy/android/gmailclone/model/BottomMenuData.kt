package udemy.android.gmailclone.model

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Notes
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String
) {
    object Mail: BottomMenuData(
        icon = Icons.Outlined.Mail,
        title = "Mail"
    )
    object Meet: BottomMenuData(
        icon = Icons.Outlined.VideoCall,
        title = "Meet"
    )
    object Note: BottomMenuData(
        icon = Icons.Outlined.Notes,
        title = "Notes"
    )
}
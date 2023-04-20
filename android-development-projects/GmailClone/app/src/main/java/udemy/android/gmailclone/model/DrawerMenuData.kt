package udemy.android.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

//Restricted class modifier sealed allows things only being seen during compile time
sealed class DrawerMenuData(
    val icon: ImageVector? = null, val title: String? = null,
    val isDivider: Boolean = false, val isHeader: Boolean = false,
) {
    object AllInboxes: DrawerMenuData(
        icon = Icons.Outlined.AllInbox,
        title = "All inboxes"
    )
    object Inbox: DrawerMenuData(
        icon = Icons.Outlined.Inbox,
        title = "Inbox"
    )
    object Primary: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Primary"
    )
    object Important: DrawerMenuData(
        icon = Icons.Outlined.PriorityHigh,
        title = "Important"
    )
    object Social: DrawerMenuData(
        icon = Icons.Outlined.Person,
        title = "Social"
    )
    object Promotions: DrawerMenuData(
        icon = Icons.Outlined.Tag,
        title = "All inboxes"
    )
    object Starred: DrawerMenuData(
        icon = Icons.Outlined.StarOutline,
        title = "Starred"
    )
    object Snoozed: DrawerMenuData(
        icon = Icons.Outlined.Snooze,
        title = "Snooze"
    )
    object Sent: DrawerMenuData(
        icon = Icons.Outlined.Send,
        title = "Sent"
    )
    object Schedule: DrawerMenuData(
        icon = Icons.Outlined.ScheduleSend,
        title = "Scheduled"
    )
    object Outbox: DrawerMenuData(
        icon = Icons.Outlined.Outbox,
        title = "Outbox"
    )
    object Draft: DrawerMenuData(
        icon = Icons.Outlined.Drafts,
        title = "Drafts"
    )
    object AllMail: DrawerMenuData(
        icon = Icons.Outlined.Mail,
        title = "All Mail"
    )
    object Calendar: DrawerMenuData(
        icon = Icons.Outlined.CalendarToday,
        title = "Calendar"
    )
    object Contacts: DrawerMenuData(
        icon = Icons.Outlined.Contacts,
        title = "Contacts"
    )
    object Setting: DrawerMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )
    object Help: DrawerMenuData(
        icon = Icons.Outlined.Help,
        title = "Help"
    )

    object Divider: DrawerMenuData(
        isDivider = true
    )
    object HeaderOne: DrawerMenuData(
        isHeader = true,
        title = "ALL LABELS"
    )
    object HeaderTwo: DrawerMenuData(
        isHeader = true,
        title = "GOOGLE APPS"
    )
}
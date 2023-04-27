package japractice.android.myfavebites.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val icon: ImageVector? = null, val title: String? = null,
    val isDivider: Boolean = false, val isHeader: Boolean = false
) {
    object Divider: DrawerMenuData(
        isDivider = true
    )
    object FlavorTaste: DrawerMenuData(
        isHeader = true,
        title = "PERSONAL TAGS"
    )
    object Cuisine: DrawerMenuData(
        isHeader = true,
        title = "CUISINE"
    )
    object SkillLevel: DrawerMenuData(
        isHeader = true,
        title = "SKILL LEVEL"
    )

    object LowSkillLevel: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Low"
    )
    object MediumSkillLevel: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Medium"
    )
    object HighSkillLevel: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "High"
    )
    object Caribbean: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Caribbean"
    )
    object SouthAsian: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "South Asian"
    )
    object WestAfrican: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "West African"
    )
    object EastAsian: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "East Asian"
    )
    object EastAfrican: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "East Asian"
    )
    object CentralEuropean: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Central European"
    )
    object CentralAmerican: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Central American"
    )
    object Brazilian: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Brazilian"
    )
    object NorthAmerican: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "North American"
    )
    object SouthAmerican: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "South American"
    )
    object Spicy: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Spicy"
    )
    object Sweet: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Sweet"
    )
    object Sour: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Sour"
    )
    object ComfortFood: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Comfort Food"
    )
    object Healthy: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Healthy"
    )
}
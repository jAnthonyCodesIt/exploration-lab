package japractice.android.myfavebites.components

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import japractice.android.myfavebites.model.DrawerMenuData

@Composable
fun FaveBitesDrawerMenu(scrollState: ScrollState) {
    val menuList = listOf(
        DrawerMenuData.Cuisine,
        DrawerMenuData.Divider,
        DrawerMenuData.Brazilian,
        DrawerMenuData.Caribbean,
        DrawerMenuData.CentralAmerican,
        DrawerMenuData.CentralEuropean,
        DrawerMenuData.EastAfrican,
        DrawerMenuData.EastAsian,
        DrawerMenuData.NorthAmerican,
        DrawerMenuData.SouthAmerican,
        DrawerMenuData.SouthAsian,
        DrawerMenuData.WestAfrican,

        DrawerMenuData.SkillLevel,
        DrawerMenuData.Divider,
        DrawerMenuData.LowSkillLevel,
        DrawerMenuData.MediumSkillLevel,
        DrawerMenuData.HighSkillLevel,

        DrawerMenuData.FlavorTaste,
        DrawerMenuData.Divider,
        DrawerMenuData.Spicy,
        DrawerMenuData.Sweet,
        DrawerMenuData.Sour,
        DrawerMenuData.ComfortFood,
        DrawerMenuData.Healthy,

        DrawerMenuData.Divider,
        DrawerMenuData.Settings,
        DrawerMenuData.Help
    )

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        // App Header
        Text(
            text = "My Fave Bites",
            color = Color.hsl(338f, .62f, .51f),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        // Dynamically fill in list of menu items
        menuList.forEach {
            item ->
            when {
                item.isDivider -> {
                    Divider(Modifier.padding(bottom = 15.dp))
                }
                item.isHeader -> {
                    Text(text = item.title!!, fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(start = 20.dp, bottom = 20.dp, top = 20.dp)
                    )
                }
                else -> {
                    FaveBitesDrawerItem(item)
                }
            }
        }
    }
}

@Composable
fun FaveBitesDrawerItem(item: DrawerMenuData) {
    Row(
        Modifier
            .height(50.dp)
            .padding(top = 16.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(0.5f)
        )
        Text(text = item.title, modifier = Modifier.weight(2.0f))
    }
}
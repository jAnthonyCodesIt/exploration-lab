package japractice.android.myfavebites.data

import japractice.android.myfavebites.R
import japractice.android.myfavebites.model.FaveBitesData

val faveBitesList = listOf(
    FaveBitesData(
        faveBiteId = 1,
        recipeName = "Tostones",
        imageIcon = R.drawable.tostones,
            skillLevel = "Low",
            prepTime = "10:00",
            description = "Tostones are a delicious and crispy Latin American treat made from fried green plantains. " +
                    "They offer a savory crunch and are a good source of fiber, vitamins, and minerals, " +
                    "including potassium, making them a guilt-free snack choice.",
            ingredients = listOf("Plantains", "Olive oil", "water", "salt"),
    ),
)
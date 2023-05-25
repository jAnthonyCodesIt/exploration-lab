package japractice.android.myfavebites.model

data class FaveBitesData(
    val faveBiteId: Int,
    val recipeName: String,
    val imageIcon: Int,
    val skillLevel: String,
    val prepTime: String,
    val description: String,
    val ingredients: List<String>
)
package udemy.android.newsapp

import android.app.Application
import udemy.android.newsapp.data.Repository
import udemy.android.newsapp.network.Api
import udemy.android.newsapp.network.NewsManager

class MainApp: Application() {
    private val manager by lazy {
        NewsManager(Api.retrofitService)
    }

    val repository by lazy {
        Repository(manager)
    }
}
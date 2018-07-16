package com.meteoro.kedditlearn

import android.app.Application
import com.meteoro.kedditlearn.di.AppModule
import com.meteoro.kedditlearn.di.news.DaggerNewsComponent
import com.meteoro.kedditlearn.di.news.NewsComponent

class KedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
//                .newsModule(NewsModule()) Module with empty constructor is implicity created by dagger.
                .build()
    }
}
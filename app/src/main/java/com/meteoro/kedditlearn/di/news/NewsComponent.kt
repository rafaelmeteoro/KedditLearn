package com.meteoro.kedditlearn.di.news

import com.meteoro.kedditlearn.di.AppModule
import com.meteoro.kedditlearn.di.NetworkModule
import com.meteoro.kedditlearn.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}
package com.meteoro.kedditlearn.features.news

import com.meteoro.kedditlearn.commons.RedditNewsItem
import rx.Observable

/**
 * News Manager allows you to request more news from Reddit.
 * */
class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            it.onNext(news)
        }
    }
}
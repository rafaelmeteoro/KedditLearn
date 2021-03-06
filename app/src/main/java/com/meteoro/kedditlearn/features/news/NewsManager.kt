package com.meteoro.kedditlearn.features.news

import com.meteoro.kedditlearn.api.NewsAPI
import com.meteoro.kedditlearn.commons.RedditNews
import com.meteoro.kedditlearn.commons.RedditNewsItem
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * News Manager allows you to request more news from Reddit API.
 * */
@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    /**
     * Returns Reddit News paginated by the given limit.
     *
     * @param after indicates the next page to navigate.
     * @param limit the number of news to request.
     * */
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create { subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body()?.data
                val news = dataResponse?.children?.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse?.after ?: "",
                        dataResponse?.before ?: "",
                        news ?: mutableListOf()
                )

                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}
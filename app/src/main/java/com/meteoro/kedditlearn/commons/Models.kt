package com.meteoro.kedditlearn.commons

import com.meteoro.kedditlearn.commons.adapter.AdapterConstants
import com.meteoro.kedditlearn.commons.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}
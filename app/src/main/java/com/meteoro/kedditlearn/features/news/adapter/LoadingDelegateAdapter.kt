package com.meteoro.kedditlearn.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.meteoro.kedditlearn.R
import com.meteoro.kedditlearn.commons.adapter.ViewType
import com.meteoro.kedditlearn.commons.adapter.ViewTypeDelegateAdapter
import com.meteoro.kedditlearn.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading))
}
package vloboda.deliveryapp.NewsApi.Adapter.ViewHolder

import android.view.View
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView

import vloboda.deliveryapp.NewsApi.R

class NewsPageViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    lateinit var webView:WebView

    init {
        webView = itemView.findViewById(R.id.webViewPagerItem)
    }



}
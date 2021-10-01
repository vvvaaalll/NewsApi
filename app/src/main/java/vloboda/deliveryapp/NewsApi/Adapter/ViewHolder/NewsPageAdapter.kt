package vloboda.deliveryapp.NewsApi.Adapter.ViewHolder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView
import vloboda.deliveryapp.NewsApi.Model.WebSite
import vloboda.deliveryapp.NewsApi.R

class NewsPageAdapter (private val context: Context, private val webSite: WebSite, val position: Int): RecyclerView.Adapter<NewsPageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsPageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.view_pager_news_item, parent, false)
        return NewsPageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsPageViewHolder, position: Int) {
       //TODO: holder!!.webView = webSite.articles!![position].url
        holder.webView.settings.javaScriptEnabled=true
        holder.webView.webChromeClient= WebChromeClient()
        holder.webView.webViewClient = object  : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }
        holder.webView.loadUrl(webSite.articles!![position].url!!)

    }

    override fun getItemCount(): Int {
        return webSite.articles!!.size
    }


}
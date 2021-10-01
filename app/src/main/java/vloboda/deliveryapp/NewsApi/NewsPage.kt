package vloboda.deliveryapp.NewsApi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import vloboda.deliveryapp.NewsApi.Adapter.ViewHolder.NewsPageAdapter
import vloboda.deliveryapp.NewsApi.Model.WebSite

class NewsPage : AppCompatActivity() {

    lateinit var webSite: WebSite
    private var position: Int?=null
    lateinit var webView: WebView
    //lateinit var adapter: NewsPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_page)



        webSite = intent!!.getSerializableExtra("webSite") as WebSite
        position = intent!!.getIntExtra("position", 0)

        webView = findViewById(R.id.WebView)

        //adapter = NewsPageAdapter(this, webSite, position!!)

        //news_view_pager.adapter = adapter


        webView.webViewClient = WebViewClient()

        // this will load the url of the website
        webView.loadUrl(webSite.articles!![position!!].url.toString())

        // this will enable the javascript settings
        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webView.canGoBack())
            webView.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.news_page_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.newsList) {
            startActivity(Intent(this, MainActivity::class.java))

        }
        return true
    }
}
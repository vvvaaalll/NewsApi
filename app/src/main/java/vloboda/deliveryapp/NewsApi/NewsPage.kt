package vloboda.deliveryapp.NewsApi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import vloboda.deliveryapp.NewsApi.Adapter.ViewHolder.NewsPageAdapter
import vloboda.deliveryapp.NewsApi.Model.WebSite

class NewsPage : AppCompatActivity() {

    lateinit var webSite: WebSite
    private var position: Int?=null
    lateinit var adapter: NewsPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_page)



        //webSite = intent!!.getSerializableExtra("webSite") as WebSite
        // position = intent!!.getIntExtra("position", 0)

        //adapter = NewsPageAdapter(this, webSite, position!!)

        //news_view_pager.adapter = adapter


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
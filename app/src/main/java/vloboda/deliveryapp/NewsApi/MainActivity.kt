package vloboda.deliveryapp.NewsApi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dmax.dialog.SpotsDialog
import vloboda.deliveryapp.NewsApi.Adapter.ViewHolder.ListSourceAdapter
import vloboda.deliveryapp.NewsApi.Interface.NewsService
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import vloboda.deliveryapp.NewsApi.Common.Common
import vloboda.deliveryapp.NewsApi.Model.WebSite

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mService: NewsService
    lateinit var adapter: ListSourceAdapter
    lateinit var dialog: SpotsDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Paper.init(this)

        mService= Common.newsService

        //TODO: load data if it's older than 5 minutes instead of swiping to refresh
        swipe_to_refresh.setOnRefreshListener {
            loadWebsiteSource(true)
        }

        rw_news.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        rw_news.layoutManager = layoutManager

        dialog = SpotsDialog(this)


        loadWebsiteSource(false)


    }

    private fun loadWebsiteSource(isRefresh: Boolean) {

        if(!isRefresh){


            val cache = Paper.book().read<String>("cache")
            if(cache != null && !cache.isBlank() && cache != "null"){
                val webSite = Gson().fromJson<WebSite>(cache, WebSite::class.java)
                adapter = ListSourceAdapter(baseContext, webSite)
                adapter.notifyDataSetChanged()
                rw_news.adapter = adapter

            }
            else{
                dialog.show()
                mService.sources.enqueue(object :retrofit2.Callback<WebSite>{

                    override fun onResponse(call: Call<WebSite>?, response: Response<WebSite>?) {


                        adapter = ListSourceAdapter(baseContext,response!!.body()!!)
                        adapter.notifyDataSetChanged()
                        rw_news.adapter = adapter

                        Paper.book().write("cache", Gson().toJson(response!!.body()!!))

                        dialog.dismiss()

                    }

                    override fun onFailure(call: Call<WebSite>?, t: Throwable?) {
                        val alertDialogBuilder = AlertDialog.Builder(baseContext)
                        alertDialogBuilder.setTitle("Greška")
                        alertDialogBuilder.setMessage("Ups, došlo je do pogreške")
                        alertDialogBuilder.setNegativeButton("U REDU") { dialogInterface: DialogInterface, i: Int -> }

                        val failureDialog = alertDialogBuilder.create()
                        failureDialog.show()
                    }
                })

            }
        }
        else{

            swipe_to_refresh.isRefreshing=true
            dialog.show()
            mService.sources.enqueue(object :retrofit2.Callback<WebSite>{

                override fun onResponse(call: Call<WebSite>?, response: Response<WebSite>?) {
                    adapter = ListSourceAdapter(baseContext,response!!.body()!!)
                    adapter.notifyDataSetChanged()
                    rw_news.adapter = adapter

                    Paper.book().write("cache", Gson().toJson(response!!.body()!!))
                    dialog.dismiss()
                    swipe_to_refresh.isRefreshing=false

                }

                override fun onFailure(call: Call<WebSite>?, t: Throwable?) {
                    val alertDialogBuilder = AlertDialog.Builder(baseContext)
                    alertDialogBuilder.setTitle("Greška")
                    alertDialogBuilder.setMessage("Ups, došlo je do pogreške")
                    alertDialogBuilder.setNegativeButton("U REDU") { dialogInterface: DialogInterface, i: Int -> }
                    val failureDialog = alertDialogBuilder.create()
                    failureDialog.show()

                }

            })



        }

    }
}
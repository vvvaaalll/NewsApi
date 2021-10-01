package vloboda.deliveryapp.NewsApi.Adapter.ViewHolder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import vloboda.deliveryapp.NewsApi.Interface.ItemClickListener
import vloboda.deliveryapp.NewsApi.Model.WebSite
import vloboda.deliveryapp.NewsApi.NewsPage
import vloboda.deliveryapp.NewsApi.NewsPageActivity
import vloboda.deliveryapp.NewsApi.R

class ListSourceAdapter (private val context: Context, private val webSite: WebSite):RecyclerView.Adapter<ListSourceViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.news_card, parent, false)
        return ListSourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListSourceViewHolder, position: Int) {
        holder!!.article_title.text = webSite.articles!![position].title
        Picasso.get().load(webSite.articles!![position].urlToImage).into(holder.article_image)

        holder.setItemClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(context, NewsPageActivity::class.java)
                intent.putExtra("position", position)
                intent.putExtra("webSite", webSite)
                context.startActivity(Intent(context, NewsPage::class.java))
                Toast.makeText(context, "ujutro uz kavicu", Toast.LENGTH_SHORT).show()


            }
        })
    }

    override fun getItemCount(): Int {
        return webSite.articles!!.size
    }


}
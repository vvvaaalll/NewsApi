package vloboda.deliveryapp.NewsApi.Adapter.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.news_card.view.*

import vloboda.deliveryapp.NewsApi.Interface.ItemClickListener



class ListSourceViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var article_title = itemView.news_card_name_tv
    var article_image = itemView.news_card_iv

    private lateinit var itemClickListener: ItemClickListener

    init {
        itemView.setOnClickListener(this)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener=itemClickListener
    }


    override fun onClick(v: View?) {
        itemClickListener.onClick(v!!,adapterPosition)
    }



}
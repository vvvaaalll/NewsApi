package vloboda.deliveryapp.NewsApi.Interface

import retrofit2.Call
import retrofit2.http.GET
import vloboda.deliveryapp.NewsApi.Model.WebSite

interface NewsService {

    @get:GET("v1/articles?source=bbc-news&sortBy=top&apiKey=6946d0c07a1c4555a4186bfcade76398")
val sources: Call<WebSite>

}
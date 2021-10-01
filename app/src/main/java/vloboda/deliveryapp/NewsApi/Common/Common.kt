package vloboda.deliveryapp.NewsApi.Common

import vloboda.deliveryapp.NewsApi.Interface.NewsService
import vloboda.deliveryapp.NewsApi.Remote.RetrofitClient


object Common {

        val BASE_URL = "https://newsapi.org/"
        val API_KEY ="6946d0c07a1c4555a4186bfcade76398"

        val newsService: NewsService
            get()= RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

    }

package vloboda.deliveryapp.NewsApi.Model
import java.io.Serializable;

class Article : Serializable{

    var author:String?=null
    var title:String?=null
    var description:String?=null
    var url:String?=null
    var urlToImage:String?=null
    var publishedAt:String?=null
}
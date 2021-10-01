package vloboda.deliveryapp.NewsApi.Model
import java.io.Serializable;

class WebSite : Serializable{
    var status:String?=null
    var source:String?=null
    var sortBy:String?=null
    var articles:List<Article>?=null

    constructor()
}
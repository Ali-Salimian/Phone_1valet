package com.example.phone.model

import java.io.Serializable

data class Cellphone(var id: String?,
                     var type: String?,
                     var price: Int,
                     var currency: String?,
                     var isFavourite: Boolean?,
                     var imageUrl: String?,
                     var title: String?,
                     var description: String?,
                     var os:String,
                     var size:String,
                     var status:String) :Serializable
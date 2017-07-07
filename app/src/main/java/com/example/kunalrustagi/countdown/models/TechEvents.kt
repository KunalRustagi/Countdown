package com.example.kunalrustagi.countdown.models

import java.io.Serializable

/**
 * Created by kunalrustagi on 07/07/17.
 */
data class TechEvents (val title:String,
                      val description:String,
                      val urlToImage:String,
                      val url:String,
                      val date:String) : Serializable

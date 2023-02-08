package com.example.ktorapicall.model

import kotlinx.serialization.Serializable

@Serializable
data class Binance(
    var openPrice : String,
    var highPrice : String,
    var lowPrice  : String,
    var volume    : String,
    var quoteVolume : String,
   
    )

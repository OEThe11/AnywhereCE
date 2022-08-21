package com.ocode.anywherece.model

data class RelatedTopic(
    val FirstURL: String,
    val Icon: Icon,
    val Result: String,
    val Text: String
){
    val parts = Text.split(" - ", limit = 2)
}
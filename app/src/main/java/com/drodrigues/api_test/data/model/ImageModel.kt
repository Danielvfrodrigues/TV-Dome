package com.drodrigues.tvdome.data.model


import com.google.gson.annotations.SerializedName

internal data class ImageModel(

    @SerializedName("medium")
    val medium: String = "",
    @SerializedName("original")
    val original: String = ""

)
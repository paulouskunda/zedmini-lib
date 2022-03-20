package com.visionarymindszm.zededitoptions.model

import com.google.gson.annotations.SerializedName


data class Cities(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null

)

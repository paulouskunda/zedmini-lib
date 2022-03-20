package com.visionarymindszm.zededitoptions.model

import com.google.gson.annotations.SerializedName


data class States(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("state_code") var stateCode: String? = null,
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("cities") var cities: ArrayList<Cities> = arrayListOf()

)
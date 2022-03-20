package com.visionarymindszm.zededitoptions.services

import com.visionarymindszm.zededitoptions.model.Countries
import com.visionarymindszm.zededitoptions.model.States
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * This class is response for making  call to the Country State City API
 * @author Paul Kunda
 * @since 2022
= */
interface ApiService {
    @GET("countryNames")
    fun getAllCountryNamesOnly(): Call<List<Countries>>

    @GET("countryStates/{countryName}")
    fun getStatesByCountryName(@Path("countryName") countryName: String): Call<List<States>>
}
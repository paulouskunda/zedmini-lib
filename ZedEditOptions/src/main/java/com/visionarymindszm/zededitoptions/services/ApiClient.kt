package com.visionarymindszm.zededitoptions.services

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class is response for making base call to the Country State City API
 * Using the Retrofit v2 library
 * @see retrofit2.Retrofit
 * @author Paul Kunda
 * @since 2022
 *
 */
object ApiClient {
    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    var BASE_URL = "https://country-state-province-city.herokuapp.com/"

    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get(){
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit
        }

}
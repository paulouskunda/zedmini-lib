package com.visionarymindszm.zededitoptions

import android.util.Log
import com.visionarymindszm.zededitoptions.model.Countries
import com.visionarymindszm.zededitoptions.services.ApiClient
import com.visionarymindszm.zededitoptions.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesUtils {

    lateinit var countries: ArrayList<String>

    fun getCountry(){
        val apiService = ApiClient.client!!.create(ApiService::class.java)
        val apiCall = apiService.getAllCountryNamesOnly()
        apiCall.enqueue(object : Callback<List<Countries>>{
            override fun onResponse(
                call: Call<List<Countries>>,
                response: Response<List<Countries>>
            ) {
                countries = ArrayList()
                val countriesResponse = response.body()
                countriesResponse?.forEach { count ->
                    run {
                        countries.add(count.name!!)
                    }
                }

                Log.i(TAG, "Countries size ${countries.size}")
                Log.i(TAG, "Country at Zero ${countries[0]}")
            }

            override fun onFailure(call: Call<List<Countries>>, t: Throwable) {
                    Log.e(TAG, "We encountered error ${t.message}")
            }

        })
    }

    fun getAllCountries(){
        val apiService = ApiClient.client!!.create(ApiService::class.java)
        val apiCall = apiService.getAllCountryNamesOnly()
        apiCall.enqueue(object : Callback<List<Countries>>{
            override fun onResponse(
                call: Call<List<Countries>>,
                response: Response<List<Countries>>
            ) {
                countries = ArrayList()
                val countriesResponse = response.body()
                countriesResponse?.forEach { count ->
                    run {
                        countries.add(count.name!!)
                    }
                }
            }

            override fun onFailure(call: Call<List<Countries>>, t: Throwable) {
                Log.e(TAG, "We encountered error ${t.message}")
            }

        })
    }

    companion object{
        const val TAG = "CountriesUtil";
    }
}
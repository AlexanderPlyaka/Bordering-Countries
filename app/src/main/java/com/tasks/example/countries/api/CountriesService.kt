package com.tasks.example.countries.api

import android.arch.lifecycle.LiveData
import retrofit2.http.GET

/**
 * REST API access points
 */
interface CountriesService {

    // a resource relative to your base URL
    @GET("rest/v2/all")
    fun getAllCountries(): LiveData<ApiResponse<List<CountriesResponse>>>

}
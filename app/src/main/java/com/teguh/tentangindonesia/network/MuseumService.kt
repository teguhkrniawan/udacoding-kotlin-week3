package com.teguh.tentangindonesia.network

import com.teguh.tentangindonesia.model.museummodel.MuseumResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MuseumService {
    @GET("searchGET")
    fun getAllMuseum(): Call<MuseumResponse>

    @GET("searchGET")
    fun searchMuseaum(
        @Query("nama") nama: String
    ): Call<MuseumResponse>
}
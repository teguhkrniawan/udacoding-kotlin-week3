package com.teguh.tentangindonesia.network

import com.teguh.tentangindonesia.model.covidmodel.CovidResponse
import retrofit2.Call
import retrofit2.http.GET

interface CovidIndoService {
    @GET("prov.json")
    fun getDataCovid(): Call<CovidResponse>
}
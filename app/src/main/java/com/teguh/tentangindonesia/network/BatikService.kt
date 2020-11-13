package com.teguh.tentangindonesia.network

import com.teguh.tentangindonesia.model.batikmodel.BatikResponse
import retrofit2.Call
import retrofit2.http.GET

interface BatikService {

    /**
     * @ENDPOINT = http://batikita.herokuapp.com/index.php/batik/all
     * @GET = "all"
     */
     @GET("all")
     fun getAllBatik(): Call<BatikResponse>

}
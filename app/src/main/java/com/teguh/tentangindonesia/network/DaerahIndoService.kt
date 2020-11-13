package com.teguh.tentangindonesia.network

import com.teguh.tentangindonesia.model.daerahmodel.KabupatenResponse
import com.teguh.tentangindonesia.model.daerahmodel.KecamatanResponse
import com.teguh.tentangindonesia.model.daerahmodel.KelurahanResponse
import com.teguh.tentangindonesia.model.daerahmodel.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DaerahIndoService {

    @GET("provinsi")
    fun getAllProvinsi(): Call<ProvinsiResponse>

    @GET("kota")
    fun getKabupaten(
        @Query("id_provinsi") id_provinsi: Int
    ): Call<KabupatenResponse>

    @GET("kecamatan")
    fun getKecamatan(
        @Query("id_kota") id_kota: Int
    ): Call<KecamatanResponse>

    @GET("kelurahan")
    fun getKelurahan(
        @Query("id_kecamatan") id_kecamatan: Int
    ): Call<KelurahanResponse>

}
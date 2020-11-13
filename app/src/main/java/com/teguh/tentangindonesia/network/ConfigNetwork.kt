package com.teguh.tentangindonesia.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ConfigNetwork {

    companion object {

        fun getBatikApi(): BatikService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/index.php/batik/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(BatikService::class.java)
        }

        fun getMuseumApi(): MuseumService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/api/index.php/CcariMuseum/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MuseumService::class.java)
        }

        fun getDaerahIndoApi(): DaerahIndoService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/api/daerahindonesia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(DaerahIndoService::class.java)
        }

        fun getCovidIndonesia(): CovidIndoService{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CovidIndoService::class.java)
        }

    }

}
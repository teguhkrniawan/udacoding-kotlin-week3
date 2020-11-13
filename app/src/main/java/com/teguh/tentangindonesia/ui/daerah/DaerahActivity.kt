package com.teguh.tentangindonesia.ui.daerah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.daerahmodel.*
import com.teguh.tentangindonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_rv_museum.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaerahActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daerah)

        val spinnerProvinsi = findViewById<Spinner>(R.id.provinsi_spinner)
        val spinnerKabupaten = findViewById<Spinner>(R.id.kabupaten_spinner)
        val spinnerKecamatan = findViewById<Spinner>(R.id.kecamatan_spinner)
        val spinnerKelurahan = findViewById<Spinner>(R.id.kelurahan_spinner)
        val configNetwork = ConfigNetwork.getDaerahIndoApi()

        /**
         * ketika apps belum mendapatkan callback data daerah
         * dari API, maka buat saja di spinner awal select provinsi
         */
        var listProvinsi: ArrayList<Provinsi> = arrayListOf()
        listProvinsi.add(0, Provinsi(0, "Select Provinsi"))
        var adapter = ArrayAdapter<Provinsi>(this@DaerahActivity, android.R.layout.simple_spinner_dropdown_item, listProvinsi)
        spinnerProvinsi.adapter = adapter

        /**
         * Dibawah ini implementasi dari API semua provinsi daerah indo yg di implementkan pada spinner
         */
        configNetwork.getAllProvinsi().enqueue(object: Callback<ProvinsiResponse>{
            override fun onFailure(call: Call<ProvinsiResponse>, t: Throwable) {
                Log.d(TAG, "onFailure provinsi: " +t.message)
            }

            override fun onResponse(
                call: Call<ProvinsiResponse>,
                response: Response<ProvinsiResponse>
            ) {
                if (response.isSuccessful){
                    listProvinsi = response.body()!!.provinsi
                    adapter = ArrayAdapter<Provinsi>(this@DaerahActivity, android.R.layout.simple_spinner_dropdown_item, listProvinsi)
                    spinnerProvinsi.adapter = adapter
                }
            }

        })

        /**
         * dibawah ini ketika item spinner provinsi selected maka akan melakukan get data kabupaten
         */
        spinnerProvinsi.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val provinsi = parent?.selectedItem as Provinsi
                configNetwork.getKabupaten(provinsi.id).enqueue(object: Callback<KabupatenResponse>{
                    override fun onFailure(call: Call<KabupatenResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure kabupaten: " +t.message)
                    }

                    override fun onResponse(
                        call: Call<KabupatenResponse>,
                        response: Response<KabupatenResponse>
                    ) {
                        if (response.isSuccessful){
//                            val gson = GsonBuilder().setPrettyPrinting().create().toJson(response.body())
//                            Log.d("RETROFIT", "onResponse: $gson")
                            val listKabupaten = response.body()!!.kota_kabupaten
                            val adapter2 = ArrayAdapter<Kabupaten>(this@DaerahActivity, android.R.layout.simple_spinner_dropdown_item, listKabupaten)
                            spinnerKabupaten.adapter = adapter2
                        }
                    }
                })
            }

        }

        /**
         * item value yg = selected akan memanggil nilai kecamatan berdasar id_kota
         */
        spinnerKabupaten.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

               val kota = parent?.selectedItem as Kabupaten

               configNetwork.getKecamatan(kota.id).enqueue(object : Callback<KecamatanResponse>{
                   override fun onFailure(call: Call<KecamatanResponse>, t: Throwable) {
                       Log.d(TAG, "onFailure kabupaten: " +t.message)
                   }

                   override fun onResponse(
                       call: Call<KecamatanResponse>,
                       response: Response<KecamatanResponse>
                   ) {
                       if (response.isSuccessful){
                           val listKecamatan = response.body()?.kecamatan
                           val adapter3 = ArrayAdapter<Kecamatan>(this@DaerahActivity, android.R.layout.simple_spinner_dropdown_item, listKecamatan ?: arrayListOf())
                           spinnerKecamatan.adapter = adapter3
                       }
                   }

               })
            }

        }

        spinnerKecamatan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, potition: Int, id: Long) {

                val kecamatan = parent?.selectedItem as Kecamatan

                configNetwork.getKelurahan(kecamatan.id).enqueue(object : Callback<KelurahanResponse>{
                    override fun onFailure(call: Call<KelurahanResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure kelurahan: " +t.message)
                    }

                    override fun onResponse(
                        call: Call<KelurahanResponse>,
                        response: Response<KelurahanResponse>
                    ) {
                        if (response.isSuccessful){

                            val gson = GsonBuilder().setPrettyPrinting().create().toJson(response.body())
                            Log.d("RETROFIT", "onResponse: $gson")

                            val listKelurahan = response.body()?.kelurahan
                            val adapter4 = ArrayAdapter<Kelurahan>(this@DaerahActivity, android.R.layout.simple_spinner_dropdown_item, listKelurahan ?: arrayListOf())
                            spinnerKelurahan.adapter = adapter4
                        }
                    }

                })
            }

        }
    }

    companion object {
        const val TAG = "DaerahActivity"
    }
}
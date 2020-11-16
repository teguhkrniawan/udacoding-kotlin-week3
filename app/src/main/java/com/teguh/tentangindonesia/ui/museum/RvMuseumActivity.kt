package com.teguh.tentangindonesia.ui.museum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.adapter.MuseumAdapter
import com.teguh.tentangindonesia.model.museummodel.Museum
import com.teguh.tentangindonesia.model.museummodel.MuseumResponse
import com.teguh.tentangindonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_rv_batik.*
import kotlinx.android.synthetic.main.activity_rv_museum.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class RvMuseumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_museum)

        val btnSearch = findViewById<Button>(R.id.museum_btn_search)
        btnSearch.setOnClickListener {

            val adpater = MuseumAdapter(arrayListOf())
            adpater.clearData()
            lv_museum.adapter = adpater
            progress_museum.visibility = View.VISIBLE

            val name = edt_museum_search.text.toString()
            ConfigNetwork.getMuseumApi().searchMuseaum(name).enqueue(object : Callback<MuseumResponse>{
                override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure search: " +t.message)
                }

                override fun onResponse(
                    call: Call<MuseumResponse>,
                    response: Response<MuseumResponse>
                ) {
                   if (response.isSuccessful){
                       progress_museum.visibility = View.GONE
                       val data = response.body()?.data
                       searchMuseum(data)
                   }
                }

            })

        }

        ConfigNetwork.getMuseumApi().getAllMuseum().enqueue(object: Callback<MuseumResponse>{
            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: " +t.message)
            }

            override fun onResponse(
                call: Call<MuseumResponse>,
                response: Response<MuseumResponse>
            ) {
               if (response.isSuccessful){
                   progress_museum.visibility = View.GONE
                   val data = response.body()?.data
                   showList(data)
               }
            }
        })
    }

    private fun searchMuseum(data: ArrayList<Museum>?) {
        val adapter = MuseumAdapter(arrayListOf())
        adapter.setDataAgain(data!!)
        lv_museum.adapter = adapter
        lv_museum.setOnItemClickListener { parent, view, position, id ->
            val item = data[position]
            val intent = Intent(this@RvMuseumActivity, DetailMuseumActivity::class.java)
            intent.putExtra(EXTRA_DETAIL_MUSEUM, item)
            startActivity(intent)
        }
    }

    private fun showList(data: ArrayList<Museum>?) {
        val adapter = MuseumAdapter(data)
        lv_museum.adapter = adapter
        lv_museum.setOnItemClickListener { parent, view, position, id ->
            val item = data?.get(position)
            val intent = Intent(this@RvMuseumActivity, DetailMuseumActivity::class.java)
            intent.putExtra(EXTRA_DETAIL_MUSEUM, item)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "RvMuseumActivity"
        const val EXTRA_DETAIL_MUSEUM = "extra_detail_museum"
    }
}
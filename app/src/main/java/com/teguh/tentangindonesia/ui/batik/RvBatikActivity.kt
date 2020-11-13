package com.teguh.tentangindonesia.ui.batik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.adapter.BatikAdapter
import com.teguh.tentangindonesia.model.batikmodel.Batik
import com.teguh.tentangindonesia.model.batikmodel.BatikResponse
import com.teguh.tentangindonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_rv_batik.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class RvBatikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_batik)

        ConfigNetwork.getBatikApi().getAllBatik().enqueue(object : Callback<BatikResponse>{
            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                Toast.makeText(applicationContext, "Failure Network", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful){
                    progress_batik.visibility = View.GONE
                    val data = response.body()?.hasil
                    showList(data)
                }
            }

        })
    }

    private fun showList(data: ArrayList<Batik>?) {
        val adapter = BatikAdapter(data!!, object: BatikAdapter.OnItemClickListener{
            override fun detailBatik(itemBatik: Batik) {
                val intent = Intent(this@RvBatikActivity, DetailBatikActivity::class.java)
                intent.putExtra(EXTRA_BATIK_KEY, itemBatik)
                startActivity(intent)
            }
        })
        rv_batik.adapter = adapter
    }

    companion object {
        const val TAG = "RvBatikActivity"
        const val EXTRA_BATIK_KEY = "extra_batik_key"
    }
}
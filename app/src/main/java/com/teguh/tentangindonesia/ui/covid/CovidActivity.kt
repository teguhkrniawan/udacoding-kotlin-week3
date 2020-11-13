package com.teguh.tentangindonesia.ui.covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.adapter.CovidAdapter
import com.teguh.tentangindonesia.model.covidmodel.CovidProvinsi
import com.teguh.tentangindonesia.model.covidmodel.CovidResponse
import com.teguh.tentangindonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_covid.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CovidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        val configNetwork = ConfigNetwork.getCovidIndonesia()

        configNetwork.getDataCovid().enqueue(object : Callback<CovidResponse>{
            override fun onFailure(call: Call<CovidResponse>, t: Throwable) {
                Log.d(TAG, "onFailure covid-19: " +t.message)
            }

            override fun onResponse(call: Call<CovidResponse>, response: Response<CovidResponse>) {
               if (response.isSuccessful){
                   covid_txt_tanggal_terbaru.text = response.body()?.last_date
                   progress_covid.visibility = View.GONE
                   val data = response.body()?.list_data
                   showList(data)
               }
            }
        })

    }

    private fun showList(data: ArrayList<CovidProvinsi>?) {
        val adapter = CovidAdapter(data, object: CovidAdapter.OnItemClickListener{
            override fun onItemClicked(item: CovidProvinsi?) {
                val intent = Intent(this@CovidActivity, DetailCovidActivity::class.java)
                intent.putExtra(EXTRA_DATA_COVID, item)
                startActivity(intent)
            }
        })
        rv_covid.adapter = adapter
    }

    companion object {
        const val TAG = "CovidActivity"
        const val EXTRA_DATA_COVID = "extra_data_covid"
    }
}
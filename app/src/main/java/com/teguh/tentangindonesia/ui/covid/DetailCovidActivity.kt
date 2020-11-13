package com.teguh.tentangindonesia.ui.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.covidmodel.CovidProvinsi

class DetailCovidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_covid)

        val itemCovid = intent.getParcelableExtra<CovidProvinsi>(CovidActivity.EXTRA_DATA_COVID)

        val totalSembuh: TextView = findViewById(R.id.detail_covid_sembuh)
        val totalRawat: TextView = findViewById(R.id.detail_covid_rawat)
        val totalMeninggal: TextView = findViewById(R.id.detail_covid_meninggal)

        if (itemCovid != null){
            totalSembuh.text = itemCovid.jumlah_sembuh
            totalMeninggal.text = itemCovid.jumlah_meninggal
            totalRawat.text = itemCovid.jumlah_dirawat
        }

    }
}
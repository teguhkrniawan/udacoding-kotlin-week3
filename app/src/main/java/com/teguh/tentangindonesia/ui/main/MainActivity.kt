package com.teguh.tentangindonesia.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.ui.batik.RvBatikActivity
import com.teguh.tentangindonesia.ui.covid.CovidActivity
import com.teguh.tentangindonesia.ui.daerah.DaerahActivity
import com.teguh.tentangindonesia.ui.museum.RvMuseumActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuBatikCard = findViewById<CardView>(R.id.menu_cv_batik)
        val menuMuseumCard = findViewById<CardView>(R.id.menu_cv_museum)
        val menuDaerahCard = findViewById<CardView>(R.id.menu_cv_daerah)
        val menuCovidCard = findViewById<CardView>(R.id.menu_cv_covid)

        menuBatikCard.setOnClickListener {
            val intent = Intent(this, RvBatikActivity::class.java)
            startActivity(intent)
        }

        menuMuseumCard.setOnClickListener {
            val intent = Intent(this, RvMuseumActivity::class.java)
            startActivity(intent)
        }

        menuDaerahCard.setOnClickListener {
            val intent = Intent(this, DaerahActivity::class.java)
            startActivity(intent)
        }

        menuCovidCard.setOnClickListener {
            val intent = Intent(this, CovidActivity::class.java)
            startActivity(intent)
        }
    }
}
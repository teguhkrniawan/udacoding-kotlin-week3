package com.teguh.tentangindonesia.ui.museum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.museummodel.Museum

class DetailMuseumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_museum)

        // intent dari museum
        val dataMuseum = intent.getParcelableExtra<Museum>(RvMuseumActivity.EXTRA_DETAIL_MUSEUM)

        val txtNameMuseum = findViewById<TextView>(R.id.detail_museum_nama)
        val txtAlamatMuseum = findViewById<TextView>(R.id.detail_museum_alamat)
        val txtKabupaten = findViewById<TextView>(R.id.detail_museum_kabupaten)
        val txtKecamatan = findViewById<TextView>(R.id.detail_museum_kecamatan)
        val txtProvinsi = findViewById<TextView>(R.id.detail_museum_provinsi)

        if (dataMuseum != null){
            txtNameMuseum.text = dataMuseum.nama
            txtAlamatMuseum.text = dataMuseum.alamat_jalan
            txtKabupaten.text = dataMuseum.kabupaten_kota
            txtKecamatan.text = dataMuseum.kecamatan
            txtProvinsi.text = dataMuseum.propinsi
        }

    }
}
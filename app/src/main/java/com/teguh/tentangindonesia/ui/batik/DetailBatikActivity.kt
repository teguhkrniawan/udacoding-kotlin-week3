package com.teguh.tentangindonesia.ui.batik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.batikmodel.Batik
import kotlinx.android.synthetic.main.activity_batik_detail.*

class DetailBatikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik_detail)

        val itemBatik = intent.getParcelableExtra<Batik>(RvBatikActivity.EXTRA_BATIK_KEY)

        val txtName = findViewById<TextView>(R.id.detail_batik_name)
        val txtKota = findViewById<TextView>(R.id.detail_batik_kota)
        val txtDeskripsi = findViewById<TextView>(R.id.detail_batik_makna)
        val txtHarga = findViewById<TextView>(R.id.detail_batik_harga)

        if (itemBatik != null){
            Glide.with(this)
                .load(itemBatik.link_batik)
                .placeholder(R.color.colorOrange)
                .into(detail_batik_img)
            txtName.text = itemBatik.nama_batik
            txtKota.text = itemBatik.daerah_batik
            txtDeskripsi.text = itemBatik.makna_batik
            txtHarga.text = convertHarga(itemBatik.harga_rendah, itemBatik.harga_tinggi)
        }
    }

    private fun convertHarga(hargaRendah: Int, hargaTinggi: Int): String {
        return "Rp.${hargaRendah} - Rp.${hargaTinggi}"
    }
}
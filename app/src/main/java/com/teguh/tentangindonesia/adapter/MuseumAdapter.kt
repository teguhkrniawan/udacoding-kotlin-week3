package com.teguh.tentangindonesia.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.museummodel.Museum

class MuseumAdapter(private val data: ArrayList<Museum>?): BaseAdapter() {

    fun clearData(){
        this.data?.clear()
        notifyDataSetChanged()
    }

    fun setDataAgain(list: ArrayList<Museum>) {
        this.data?.clear()
        this.data?.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(potition: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout_museum, parent, false)

        val name = view.findViewById<TextView>(R.id.museum_item_name)
        val alamat = view.findViewById<TextView>(R.id.museum_item_alamat)

        val item = data?.get(potition)
        name.text = item?.nama
        alamat.text = "${item?.alamat_jalan}, ${item?.kecamatan}, ${item?.kabupaten_kota}, ${item?.propinsi}"

        return view
    }

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: 0
    }

    override fun getItemId(potition: Int): Long {
        return potition.toLong()
    }

    override fun getCount(): Int {
        return data?.size ?: 0
    }
}
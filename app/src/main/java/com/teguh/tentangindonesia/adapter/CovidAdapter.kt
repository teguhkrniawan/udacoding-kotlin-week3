package com.teguh.tentangindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.covidmodel.CovidProvinsi

class CovidAdapter(private val data: ArrayList<CovidProvinsi>?, private val itemClick: OnItemClickListener) : RecyclerView.Adapter<CovidAdapter.MyViewHodlder>(){

    inner class MyViewHodlder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val txtNamaDaerah: TextView = itemview.findViewById<TextView>(R.id.item_covid_provinsi)
        val txtJumlahKasus: TextView = itemview.findViewById<TextView>(R.id.item_covid_jumlah_kasus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodlder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_covid, parent, false)
        return MyViewHodlder(view)
    }

    override fun getItemCount(): Int {
       return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHodlder, position: Int) {

        val item = data?.get(position)
        holder.txtNamaDaerah.text = item?.key
        holder.txtJumlahKasus.text = item?.jumlah_kasus + " Kasus"
        holder.itemView.setOnClickListener {
            itemClick.onItemClicked(item)
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: CovidProvinsi?)
    }

}
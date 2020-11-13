package com.teguh.tentangindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teguh.tentangindonesia.R
import com.teguh.tentangindonesia.model.batikmodel.Batik

class BatikAdapter(private val data: ArrayList<Batik>, private val itemClick: OnItemClickListener): RecyclerView.Adapter<BatikAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.item_batik_name)
        val txtDescription = itemView.findViewById<TextView>(R.id.item_batik_description)
        val ivBatik = itemView.findViewById<ImageView>(R.id.item_batik_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_batik, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = data[position]

        holder.txtName.text = item.nama_batik
        holder.txtDescription.text = item.makna_batik
        Glide.with(holder.itemView.context)
            .load(item.link_batik)
            .placeholder(R.color.colorOrange)
            .into(holder.ivBatik)

        holder.itemView.setOnClickListener {
            itemClick.detailBatik(item)
        }

    }

    interface OnItemClickListener {
        fun detailBatik (itemBatik: Batik)
    }

}
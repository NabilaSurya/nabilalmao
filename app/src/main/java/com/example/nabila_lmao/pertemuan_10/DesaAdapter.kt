package com.example.nabila_lmao.pertemuan_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nabila_lmao.R

class DesaAdapter(private val list: ArrayList<Desa>)
    : RecyclerView.Adapter<DesaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nama = itemView.findViewById<TextView>(R.id.tvNama)
        val deskripsi = itemView.findViewById<TextView>(R.id.tvDeskripsi)
        val gambar = itemView.findViewById<ImageView>(R.id.imgAset)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_desa, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.nama.text = item.nama
        holder.deskripsi.text = item.deskripsi

        // Proses Glide meload URL Gambar web ke ImageView
        Glide.with(holder.itemView.context)
            .load(item.gambarUrl)
            .centerCrop() // Agar gambar terpotong rapi memenuhi kotak layout
            .placeholder(android.R.drawable.progress_horizontal) // Loading sementara gambar diunduh
            .error(android.R.drawable.stat_notify_error) // Jika internet mati / link rusak
            .into(holder.gambar)
    }
}
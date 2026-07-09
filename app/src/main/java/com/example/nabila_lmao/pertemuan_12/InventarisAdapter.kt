package com.example.nabila_lmao.pertemuan_12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_lmao.databinding.ItemInventarisBinding

class InventarisAdapter(
    private val list: MutableList<Inventaris>,
    private val onDelete: (Inventaris) -> Unit
) : RecyclerView.Adapter<InventarisAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemInventarisBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemInventarisBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.binding.tvNama.text = item.nama
        holder.binding.tvKategori.text = item.kategori

        holder.binding.btnDelete.setOnClickListener {
            onDelete(item)
        }

    }

    fun setData(data: List<Inventaris>) {

        list.clear()
        list.addAll(data)
        notifyDataSetChanged()

    }
}
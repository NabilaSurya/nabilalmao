package com.example.nabila_lmao.pertemuan_10

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_lmao.R

class AsetDesaFragment : Fragment(R.layout.fragment_aset_desa) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        val data = arrayListOf(
            Desa("Mobil Operasional", "Mobil dinas untuk kegiatan darurat dan sosial desa.", "https://images.unsplash.com/photo-1549399542-7e3f8b79c341?w=400"),
            Desa("Gedung Serbaguna", "Gedung olahraga dan persewaan acara masyarakat.", "https://images.unsplash.com/photo-1545232979-8bf34eb9757b?w=400"),
            Desa("Tanah Kas Desa", "Lahan pertanian produktif milik pemerintah daerah.", "https://images.unsplash.com/photo-1622383563227-04401ab4e5ea?w=400"),
            Desa("Mesin Traktor", "Alat penunjang kelompok tani penggarap tanah kas.", "https://images.unsplash.com/photo-1530268578403-1070e1c01579?w=400")
        )

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = DesaAdapter(data)
    }
}
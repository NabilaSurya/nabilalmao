package com.example.nabila_lmao.pertemuan_10

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_lmao.R

class FasilitasFragment : Fragment(R.layout.fragment_fasilitas) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        val data = arrayListOf(
            Desa("Balai Desa", "Pusat pelayanan administrasi dan organisasi warga.", "https://images.unsplash.com/photo-1577086664693-894d8405334a?w=400"),
            Desa("Puskesmas", "Pelayanan kesehatan dan imunisasi warga desa.", "https://images.unsplash.com/photo-1584515933487-75982136b247?w=400"),
            Desa("Sekolah Dasar", "Gedung pendidikan dasar anak-anak usia dini desa.", "https://images.unsplash.com/photo-1580582932707-520aed937b7b?w=400"),
            Desa("Balai Pertemuan", "Tempat musyawarah dan rapat rutin berkala.", "https://images.unsplash.com/photo-1517502884422-41eaaced0168?w=400")
        )

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = DesaAdapter(data)
    }
}
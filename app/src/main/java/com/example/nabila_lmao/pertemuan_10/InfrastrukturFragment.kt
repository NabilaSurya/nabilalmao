package com.example.nabila_lmao.pertemuan_10

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_lmao.R

class InfrastrukturFragment : Fragment(R.layout.fragment_infrastruktur) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)

        val data = arrayListOf(
            Desa("Jalan Beton Utama", "Akses jalan penghubung utama antar dusun barat.", "https://images.unsplash.com/photo-1544984243-ec57ea16fe25?w=400"),
            Desa("Jembatan Sungai", "Jembatan penyeberangan kokoh di atas aliran sungai.", "https://images.unsplash.com/photo-1545562083-a600704fa486?w=400"),
            Desa("Drainase Sawah", "Saluran irigasi pengairan area sawah selatan.", "https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=400"),
            Desa("Penerangan Jalan", "Fasilitas lampu jalan bertenaga surya malam hari.", "https://images.unsplash.com/photo-1509395062183-67c5ad6faff9?w=400")
        )

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = DesaAdapter(data)
    }
}
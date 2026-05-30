package com.example.nabila_lmao.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.nabila_lmao.R
import com.example.nabila_lmao.pertemuan_10.InfoDesaActivity
import com.example.nabila_lmao.pertemuan_2.HitungActivity
import com.example.nabila_lmao.pertemuan_3.WelcomeActivity
import com.example.nabila_lmao.pertemuan_4.Custom2Activity
import com.example.nabila_lmao.pertemuan_9.InventarisActivity
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi tombol di dalam Fragment
        val btn1 = view.findViewById<MaterialButton>(R.id.btn1)
        val btn2 = view.findViewById<MaterialButton>(R.id.btn2)
        val btnWelcome = view.findViewById<MaterialButton>(R.id.btnWelcome)
        val btnInventaris = view.findViewById<MaterialButton>(R.id.btnInventaris)
        val btn3 = view.findViewById<MaterialButton>(R.id.btn3)
        val btnInfoDesa = view.findViewById<MaterialButton>(R.id.btnInfoDesa)

        // Tombol Kalkulator
        btn1.setOnClickListener {
            startActivity(Intent(requireContext(), HitungActivity::class.java))
        }

        // Tombol Katalog Aset
        btn2.setOnClickListener {
            startActivity(Intent(requireContext(), Custom2Activity::class.java))
        }

        // Tombol Detail Aset
        btnWelcome.setOnClickListener {
            val intent = Intent(requireContext(), WelcomeActivity::class.java)
            intent.putExtra("USERNAME", "Nabila")
            startActivity(intent)
        }

        // Tombol Inventaris Desa (Pertemuan 9)
        btnInventaris.setOnClickListener {
            startActivity(Intent(requireContext(), InventarisActivity::class.java))
        }

        // Tombol Website Bina Desa
        btn3.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Tombol InfoDesa
        btnInfoDesa.setOnClickListener {
            startActivity(Intent(requireContext(), InfoDesaActivity::class.java))
        }
    }
}
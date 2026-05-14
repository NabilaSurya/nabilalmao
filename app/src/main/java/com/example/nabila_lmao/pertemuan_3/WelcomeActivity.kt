package com.example.nabila_lmao.pertemuan_3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Ambil data dengan nilai default untuk mencegah tampilan kosong
        val name = intent.getStringExtra("USERNAME") ?: "User"
        val desc = intent.getStringExtra("DESC") ?: "Deskripsi tidak tersedia"

        // 2. Set ke tampilan
        // Kamu bisa menggunakan template string seperti ini
        binding.tvWelcome.text = "Halo $name, Selamat Siang! 🎉"
        binding.tvDesc.text = desc

        // 3. Tombol pesan
        binding.btnPesanPaket.setOnClickListener {
            showToast("Pesanan diproses 🍱")
        }
        binding.btnBackToDashboard.setOnClickListener {
            finish()
        }
    }

    // Fungsi pembantu agar kode lebih bersih
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
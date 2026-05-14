package com.example.nabila_lmao.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityCustom2Binding
import com.example.nabila_lmao.pertemuan_3.LoginActivity

class Custom2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi binding
        binding = ActivityCustom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Gunakan binding untuk mengakses komponen (tvTitle, tvDesc, btnOrder)
        val title = intent.getStringExtra("TITLE")
        val desc = intent.getStringExtra("DESC")

        binding.tvTitle.text = title
        binding.tvDesc.text = desc

        binding.btnOrder.setOnClickListener {
            Toast.makeText(this, "Pesanan diproses 🍔", Toast.LENGTH_SHORT).show()
        }

        // 3. Tombol Kembali ke Login
        binding.btnBackToDashboard.setOnClickListener {
            finish() // Atau arahkan ke DashboardActivity
        }
    }
}
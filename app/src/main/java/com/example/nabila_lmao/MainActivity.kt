package com.example.nabila_lmao.pertemuan_4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityMainBinding
import com.example.nabila_lmao.pertemuan_2.HitungActivity
import com.example.nabila_lmao.pertemuan_3.LoginActivity
import com.example.nabila_lmao.pertemuan_3.WelcomeActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = "Dashboard Aplikasi"
        val desc = "Pilih menu yang ingin digunakan"

        // tombol 1 → Hitung
        binding.btn1.setOnClickListener {
            val intent = Intent(this, HitungActivity::class.java)
            intent.putExtra("TITLE", title)
            intent.putExtra("DESC", desc)
            startActivity(intent)
        }

        // tombol 2 → Welcome
        binding.btn2.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USERNAME", "Nabila")
            intent.putExtra("TITLE", title)
            intent.putExtra("DESC", desc)
            startActivity(intent)
        }

        // tombol 3 → Custom 2
        binding.btn3.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("TITLE", title)
            intent.putExtra("DESC", desc)
            startActivity(intent)
        }

        // tombol 4 → Logout
        binding.btnLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Yakin ingin logout?")
            .setPositiveButton("Ya") { _, _ ->
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
                Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }
}
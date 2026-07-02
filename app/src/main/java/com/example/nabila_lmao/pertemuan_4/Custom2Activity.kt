package com.example.nabila_lmao.pertemuan_4

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityCustom2Binding
import com.example.nabila_lmao.pertemuan_9.InventarisActivity
import com.example.nabila_lmao.utils.NotificationHelper
import com.example.nabila_lmao.utils.PermissionHelper

class Custom2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom2Binding

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        // 1. Inisialisasi binding
        binding = ActivityCustom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Mengambil data dari Intent
        val title = intent.getStringExtra("TITLE")
        val desc = intent.getStringExtra("DESC")

        // Set judul: Pakai data intent jika ada, kalau tidak pakai default
        binding.tvTitle.text = title ?: "Balai Desa Utama"

        // Set Kategori
        binding.tvCategory.text = "Kategori: Bangunan Publik"

        // FIX: Langsung masukkan teks lengkap jika data 'desc' dari intent kosong
        if (desc != null) {
            binding.tvDescription.text = desc
        } else {
            binding.tvDescription.text = "Gedung ini merupakan aset utama desa yang berfungsi sebagai pusat administrasi, pertemuan warga, dan pelayanan publik. Dibangun pada tahun 2010 dan telah direnovasi untuk memastikan kenyamanan masyarakat dalam mendapatkan pelayanan administrasi kependudukan."
        }

        binding.btnOrder.setOnClickListener {
            val intent = Intent(this, InventarisActivity::class.java)

            //startActivity(intent)

            NotificationHelper.showNotification(
                this, //Jika panggil di fragment maka requireContext()
                "Halaman Detail Inventaris",
                "Halo, silahkan dibukaa",
                intent
            )
        }

        // 3. Tombol Kembali
        binding.btnBackToDashboard.setOnClickListener {
            finish()
        }
    }
}
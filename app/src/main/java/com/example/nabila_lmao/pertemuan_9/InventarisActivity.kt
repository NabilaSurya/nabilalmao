package com.example.nabila_lmao.pertemuan_9

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.R
import com.example.nabila_lmao.utils.ReminderHelper
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class InventarisActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var etNamaAset: TextInputEditText
    private lateinit var btnTambah: MaterialButton

    private lateinit var adapter: ArrayAdapter<String>

    private val dataAset = arrayListOf(
        "Balai Desa",
        "Mobil Operasional",
        "Laptop Kantor",
        "Proyektor Aula",
        "Tanah Kas Desa",
        "Mesin Pemotong Rumput",
        "Printer Administrasi",
        "Motor Dinas"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventaris)

        listView = findViewById(R.id.listInventaris)
        etNamaAset = findViewById(R.id.etNamaAset)
        btnTambah = findViewById(R.id.btnTambah)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            dataAset
        )

        listView.adapter = adapter

        // Klik item
        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Aset: ${dataAset[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Tombol Tambah Inventaris
        btnTambah.setOnClickListener {

            val namaAset = etNamaAset.text.toString().trim()

            if (namaAset.isEmpty()) {
                etNamaAset.error = "Nama aset tidak boleh kosong"
                return@setOnClickListener
            }

            // Tambahkan ke ListView
            dataAset.add(namaAset)
            adapter.notifyDataSetChanged()
            etNamaAset.setText("")

            // Intent ketika notifikasi ditekan
            val intent = Intent(this, InventarisActivity::class.java)

            // Reminder 1 menit
            val calendar = Calendar.getInstance().apply {
                add(Calendar.MINUTE, 1)
            }

            ReminderHelper.setReminder(
                context = this,
                hour = calendar.get(Calendar.HOUR_OF_DAY),
                minute = calendar.get(Calendar.MINUTE),
                title = "Inventaris Desa",
                message = "Inventaris \"$namaAset\" berhasil ditambahkan.",
                targetActivity = InventarisActivity::class.java
            )

            Toast.makeText(
                this,
                "Inventaris berhasil ditambahkan.\nNotifikasi akan muncul dalam 1 menit.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
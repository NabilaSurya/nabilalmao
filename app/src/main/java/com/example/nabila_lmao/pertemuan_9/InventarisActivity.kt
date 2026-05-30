package com.example.nabila_lmao.pertemuan_9

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.R

class InventarisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventaris)

        val listView = findViewById<ListView>(R.id.listInventaris)

        val dataAset = arrayListOf(
            "Balai Desa",
            "Mobil Operasional",
            "Laptop Kantor",
            "Proyektor Aula",
            "Tanah Kas Desa",
            "Mesin Pemotong Rumput",
            "Printer Administrasi",
            "Motor Dinas"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            dataAset
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Aset: ${dataAset[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
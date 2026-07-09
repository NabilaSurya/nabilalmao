package com.example.nabila_lmao.pertemuan_9

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nabila_lmao.R

class SimpleAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)

        val listView = findViewById<ListView>(R.id.listView)

        val data = ArrayList<HashMap<String, String>>()

        val item1 = HashMap<String, String>()
        item1["judul"] = "Balai Desa"
        item1["kategori"] = "Bangunan"

        val item2 = HashMap<String, String>()
        item2["judul"] = "Laptop"
        item2["kategori"] = "Elektronik"

        data.add(item1)
        data.add(item2)

        val adapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            arrayOf("judul", "kategori"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter
    }
}
package com.example.nabila_lmao.pertemuan_12

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nabila_lmao.databinding.ActivityInventarisRoomBinding
import kotlinx.coroutines.launch

class InventarisRoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInventarisRoomBinding

    private lateinit var db: AppDatabase

    private lateinit var adapter: InventarisAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInventarisRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)

        adapter = InventarisAdapter(
            mutableListOf()
        ) { inventaris ->

            AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Yakin ingin menghapus ${inventaris.nama}?")
                .setPositiveButton("Ya") { _, _ ->

                    lifecycleScope.launch {

                        db.inventarisDao().delete(inventaris)

                        loadData()

                        Toast.makeText(
                            this@InventarisRoomActivity,
                            "Data berhasil dihapus",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }
                .setNegativeButton("Batal", null)
                .show()

        }

        binding.recyclerInventaris.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerInventaris.adapter = adapter

        binding.recyclerInventaris.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        loadData()

        binding.btnTambah.setOnClickListener {

            val nama =
                binding.etNamaAset.text.toString().trim()

            if (nama.isEmpty()) {

                binding.etNamaAset.error =
                    "Nama inventaris wajib diisi"

                return@setOnClickListener
            }

            lifecycleScope.launch {

                db.inventarisDao().insert(

                    Inventaris(
                        nama = nama,
                        kategori = "Bangunan"
                    )

                )

                binding.etNamaAset.setText("")

                loadData()

                Toast.makeText(
                    this@InventarisRoomActivity,
                    "Data berhasil ditambahkan",
                    Toast.LENGTH_SHORT
                ).show()

            }

        }

    }

    private fun loadData() {

        lifecycleScope.launch {

            val data =
                db.inventarisDao().getAll()

            adapter.setData(data)

        }

    }

}
package com.example.nabila_lmao.pertemuan_12

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventaris")
data class Inventaris(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nama: String,

    val kategori: String
)
package com.example.nabila_lmao.pertemuan_12

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InventarisDao {

    @Insert
    suspend fun insert(inventaris: Inventaris)

    @Delete
    suspend fun delete(inventaris: Inventaris)

    @Query("SELECT * FROM inventaris ORDER BY id DESC")
    suspend fun getAll(): List<Inventaris>

}
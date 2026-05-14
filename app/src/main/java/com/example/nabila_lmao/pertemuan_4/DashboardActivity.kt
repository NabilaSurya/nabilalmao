package com.example.nabila_lmao.pertemuan_4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.nabila_lmao.R
import com.example.nabila_lmao.pertemuan_3.LoginActivity
import com.example.nabila_lmao.pertemuan_6.AboutFragment
import com.example.nabila_lmao.pertemuan_6.HomeFragment
import com.example.nabila_lmao.pertemuan_6.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Bina Desa - Dashboard"

        // Default Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        // Bottom Navigation
        val bottomNav =
            findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_home -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()

                    true
                }

                R.id.nav_about -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AboutFragment())
                        .commit()

                    true
                }

                R.id.nav_profile -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment())
                        .commit()

                    true
                }

                else -> false
            }
        }
    }

    // Function Logout
    fun performLogout() {

        val sharedPref =
            getSharedPreferences("BinaDesaPrefs", Context.MODE_PRIVATE)

        val editor = sharedPref.edit()

        editor.clear()
        editor.apply()

        Snackbar.make(
            findViewById(android.R.id.content),
            "Berhasil logout",
            Snackbar.LENGTH_SHORT
        ).show()

        val intent = Intent(this, LoginActivity::class.java)

        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
        finish()
    }

    // Dialog Logout
    fun showLogoutDialog() {

        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Yakin ingin keluar dari aplikasi?")
            .setPositiveButton("Ya") { _, _ ->

                performLogout()
            }

            .setNegativeButton("Tidak") { dialog, _ ->

                dialog.dismiss()
            }

            .show()
    }
}
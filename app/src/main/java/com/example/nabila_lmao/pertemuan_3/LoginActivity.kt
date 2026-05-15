package com.example.nabila_lmao.pertemuan_3

import android.content.Context // Tambahkan ini
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityLoginBinding
import com.example.nabila_lmao.kuis.RegisterActivity
import com.example.nabila_lmao.pertemuan_4.DashboardActivity
import com.example.nabila_lmao.pertemuan_6.SessionManager

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Navigasi ke Halaman Register
        binding.tvToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // 3. Logika Tombol Login
        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()

            // Ambil data dari SharedPreferences hasil Registrasi
            val sharedPref = getSharedPreferences("BinaDesaPrefs", Context.MODE_PRIVATE)
            val savedUser = sharedPref.getString("saved_user", null)
            val savedPass = sharedPref.getString("saved_pass", null)

            when {
                user.isEmpty() || pass.isEmpty() -> {
                    showToast("Harap isi username dan password!")
                }
                user.length < 3 -> {
                    showToast("Username minimal 3 karakter")
                }
                else -> {
                    // Terapkan Rule Login
                    val isRulePraktikum = (user == pass) // Rule: Username sama dengan Password
                    val isRuleRegister = (user == savedUser && pass == savedPass) // Rule: Sesuai data Register

                    if (isRulePraktikum || isRuleRegister) {
                        // SIMPAN SESSION
                        val session = SessionManager(this)
                        session.saveLoginStatus(true, user)

                        showToast("Selamat Datang, $user!")

                        // PINDAH KE DASHBOARD
                        val intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Jika kedua rule di atas tidak terpenuhi
                        showToast("Username atau Password salah!")
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
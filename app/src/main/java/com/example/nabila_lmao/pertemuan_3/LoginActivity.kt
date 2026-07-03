package com.example.nabila_lmao.pertemuan_3

import android.content.Context
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

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NAVIGASI KE REGISTER
        binding.tvToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // LOGIN BUTTON
        binding.btnLogin.setOnClickListener {

            val user = binding.etUsername.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()

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

                    val isRulePraktikum = (user == pass)
                    val isRuleRegister = (user == savedUser && pass == savedPass)

                    if (isRulePraktikum || isRuleRegister) {

                        // SESSION (tetap kamu pakai)
                        val session = SessionManager(this)
                        session.saveLoginStatus(true, user)

                        showToast("Selamat Datang, $user!")

                        val intent = Intent(this, DashboardActivity::class.java)
                        intent.putExtra("USERNAME", user)
                        startActivity(intent)
                        finish()

                    } else {
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
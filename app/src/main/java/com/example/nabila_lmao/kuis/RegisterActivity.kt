package com.example.nabila_lmao.kuis

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Dropdown Agama
        val daftarAgama = arrayOf("Islam", "Kristen", "Katolik", "Hindu", "Budha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, daftarAgama)
        binding.spAgama.adapter = adapter

        // 2. Setup DatePicker
        binding.etTanggalLahir.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(this, { _, year, month, day ->
                binding.etTanggalLahir.setText("$day/${month + 1}/$year")
                binding.tilTanggalLahir.error = null
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
        }

        // 3. Tombol Register dengan Validasi Lengkap
        binding.btnRegister.setOnClickListener {
            if (validateForm()) {
                saveDataToSharedPref()
            }
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        // Validasi Nama
        if (binding.etNama.text.toString().trim().isEmpty()) {
            binding.tilNama.error = "Nama Lengkap wajib diisi!"
            isValid = false
        } else {
            binding.tilNama.error = null
        }

        // Validasi Tanggal Lahir
        if (binding.etTanggalLahir.text.toString().isEmpty()) {
            binding.tilTanggalLahir.error = "Tanggal lahir belum dipilih!"
            isValid = false
        } else {
            binding.tilTanggalLahir.error = null
        }

        // Validasi Username
        val user = binding.etRegUsername.text.toString().trim()
        if (user.isEmpty()) {
            binding.tilUsername.error = "Username tidak boleh kosong!"
            isValid = false
        } else {
            binding.tilUsername.error = null
        }

        // Validasi Password
        val pass = binding.etRegPassword.text.toString().trim()
        if (pass.isEmpty()) {
            binding.tilPassword.error = "Password wajib diisi!"
            isValid = false
        } else if (pass.length < 6) {
            binding.tilPassword.error = "Password minimal 6 karakter!"
            isValid = false
        } else {
            binding.tilPassword.error = null
        }

        // Validasi Confirm Password (Harus Sama)
        val confirm = binding.etRegConfirmPassword.text.toString().trim()
        if (confirm != pass) {
            binding.tilConfirmPassword.error = "Konfirmasi password tidak cocok!"
            isValid = false
        } else {
            binding.tilConfirmPassword.error = null
        }

        // Cek Jenis Kelamin (Khusus RadioButton tidak punya til, bisa lewat indikasi lain)
        if (binding.rgGender.checkedRadioButtonId == -1) {
            isValid = false
            // Opsional: berikan pesan manual di TextView label gender jika ada
        }

        return isValid
    }

    private fun saveDataToSharedPref() {
        // SIMPAN KE SP (SharedPreferences)
        val sharedPref = getSharedPreferences("BinaDesaPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putString("saved_nama", binding.etNama.text.toString())
        editor.putString("saved_user", binding.etRegUsername.text.toString())
        editor.putString("saved_pass", binding.etRegPassword.text.toString())
        editor.putString("is_registered", "true")

        editor.apply()

        // Berhasil, kembali ke Login
        finish()
    }
}
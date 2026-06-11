package com.example.nabila_lmao.pertemuan_11

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nabila_lmao.R
import com.example.nabila_lmao.databinding.ActivityOnboardingBinding
import com.example.nabila_lmao.pertemuan_3.LoginActivity

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Panggil fungsi fullscreen sebelum logika lainnya
        setupFullscreen()

        // Data Onboarding (Gunakan gambar yang bagus agar fullscreen terlihat maksimal)
        val list = listOf(
            OnBoardingItem(
                R.drawable.img_4,
                "Sistem Informasi Desa",
                "Selamat datang di Bina Desa! Sistem digital mutakhir yang dirancang khusus untuk memodernisasi tata kelola lingkungan desa Anda."
            ),
            OnBoardingItem(
                R.drawable.img_5,
                "Manajemen Aset Akurat",
                "Pantau pergerakan, kondisi fisik, dan kalkulasi nilai aset inventaris milik desa secara real-time demi transparansi publik."
            ),
            OnBoardingItem(
                R.drawable.img_6,
                "Pelaporan Digital Instan",
                "Susun dan cetak berkas laporan inventarisasi aset desa hanya dengan satu klik mudah tanpa prosedur administrasi yang rumit."
            )
        )

        // Set adapter ke ViewPager2
        binding.viewPager.adapter = OnBoardingAdapter(list)

        // Menghubungkan dotsIndicator dengan ViewPager2
        binding.dotIndicator.attachTo(binding.viewPager)

        // Logika memunculkan tombol di slide terakhir
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    if (position == 2) {
                        binding.btnMulai.visibility = View.VISIBLE
                    } else {
                        binding.btnMulai.visibility = View.GONE
                    }
                }
            }
        )

        // Aksi tombol Mulai menuju ke LoginActivity
        binding.btnMulai.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )
            finish()
        }
    }

    // Fungsi untuk membuat activity fullscreen (menyembunyikan status bar dan nav bar)
    private fun setupFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let { controller ->
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            // Deprecated untuk Android lama, tapi tetap perlu untuk kompatibilitas
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
    }
}
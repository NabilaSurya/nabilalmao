package com.example.nabila_lmao.pertemuan_6

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup ToolbarZ
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Website Bina Desa"
            setDisplayHomeAsUpEnabled(true)
        }

        // 2. Setup Migrasi OnBackPressedDispatcher
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Logika: Jika WebView bisa kembali, maka kembali. Jika tidak, tutup Activity.
                if (binding.webViewDesa.canGoBack()) {
                    binding.webViewDesa.goBack()
                } else {
                    finish()
                }
            }
        }
        // Daftarkan callback ke dispatcher
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        // 3. Setup WebView
        binding.webViewDesa.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = WebViewClient()

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.progressBar.progress = newProgress
                    if (newProgress == 100) {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
            loadUrl("https://nabila16.alwaysdata.net/")
        }
    }

    // Tombol Back di Toolbar (Panah Kiri Atas)
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
package com.example.nabila_lmao.pertemuan_13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.R
import com.google.android.material.button.MaterialButton

class ThirteenthActivity : AppCompatActivity() {

    private lateinit var btnCamera: MaterialButton
    private lateinit var btnGenerate: MaterialButton
    private lateinit var btnScan: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thirteenth)

        btnCamera = findViewById(R.id.btnCamera)
        btnGenerate = findViewById(R.id.btnGenerate)
        btnScan = findViewById(R.id.btnScan)

        // Fragment pertama saat Activity dibuka
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CameraFragment())
                .commit()
        }

        btnCamera.setOnClickListener {
            openFragment(CameraFragment())
        }

        btnGenerate.setOnClickListener {
            openFragment(GenerateQRFragment())
        }

        btnScan.setOnClickListener {
            openFragment(ScanQRFragment())
        }
    }

    private fun openFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
package com.example.nabila_lmao.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_lmao.R
import com.example.nabila_lmao.pertemuan_4.DashboardActivity
import com.example.nabila_lmao.pertemuan_11.OnBoardingActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            val session = SessionManager(this)

            if (session.isLoggedIn()) {

                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra(
                    "USERNAME",
                    session.getUsername() ?: "User"
                )
                startActivity(intent)

            } else {

                startActivity(
                    Intent(
                        this,
                        OnBoardingActivity::class.java
                    )
                )
            }

            finish()

        }, 3000)
    }
}
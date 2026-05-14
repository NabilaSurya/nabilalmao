package com.example.nabila_lmao.pertemuan_6

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.nabila_lmao.R
import com.example.nabila_lmao.pertemuan_4.DashboardActivity
import com.google.android.material.button.MaterialButton

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogout =
            view.findViewById<MaterialButton>(R.id.btnLogoutInFragment)

        btnLogout.setOnClickListener {

            // Ambil activity Dashboard
            val activityDashboard = activity as? DashboardActivity

            // Jalankan function logout
            activityDashboard?.performLogout()
        }
    }
}
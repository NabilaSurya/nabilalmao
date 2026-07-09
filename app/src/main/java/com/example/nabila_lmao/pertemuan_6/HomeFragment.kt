package com.example.nabila_lmao.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_lmao.R
import com.example.nabila_lmao.pertemuan_10.InfoDesaActivity
import com.example.nabila_lmao.pertemuan_11.News
import com.example.nabila_lmao.pertemuan_11.NewsAdapter
import com.example.nabila_lmao.pertemuan_11.RetrofitClient
import com.example.nabila_lmao.pertemuan_12.InventarisRoomActivity
import com.example.nabila_lmao.pertemuan_13.ThirteenthActivity
import com.example.nabila_lmao.pertemuan_2.HitungActivity
import com.example.nabila_lmao.pertemuan_3.WelcomeActivity
import com.example.nabila_lmao.pertemuan_4.Custom2Activity
import com.example.nabila_lmao.pertemuan_9.InventarisActivity
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil username dari Bundle
        val username = arguments?.getString("USERNAME") ?: "Admin Aset"

        // Tampilkan ke TextView
        val tvWelcome = view.findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "Halo $username,"

        val btn1 = view.findViewById<MaterialButton>(R.id.btn1)
        val btn2 = view.findViewById<MaterialButton>(R.id.btn2)
        val btnWelcome = view.findViewById<MaterialButton>(R.id.btnWelcome)
        val btnInventaris = view.findViewById<MaterialButton>(R.id.btnInventaris)
        val btnInventarisRoom =
            view.findViewById<MaterialButton>(R.id.btnInventarisRoom)
        val btn3 = view.findViewById<MaterialButton>(R.id.btn3)
        val btnInfoDesa = view.findViewById<MaterialButton>(R.id.btnInfoDesa)
        val btnLogout = view.findViewById<MaterialButton>(R.id.btnLogout)
        val btnPertemuan13=view.findViewById<MaterialButton>(R.id.btnPertemuan13)

        recyclerView = view.findViewById(R.id.recyclerViewNews)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        loadNews()

        btn1.setOnClickListener {
            startActivity(Intent(requireContext(), HitungActivity::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(requireContext(), Custom2Activity::class.java))
        }

        btnWelcome.setOnClickListener {
            val intent = Intent(requireContext(), WelcomeActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
        }

        btnInventaris.setOnClickListener {
            startActivity(Intent(requireContext(), InventarisActivity::class.java))
        }
        btnInventarisRoom.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    InventarisRoomActivity::class.java
                )
            )
        }
        btnPertemuan13.setOnClickListener{

            startActivity(
                Intent(requireContext(), ThirteenthActivity::class.java)
            )

        }

        btn3.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        btnInfoDesa.setOnClickListener {
            startActivity(Intent(requireContext(), InfoDesaActivity::class.java))
        }
        btnLogout.setOnClickListener {
            (activity as? com.example.nabila_lmao.pertemuan_4.DashboardActivity)
                ?.showLogoutDialog()
        }


    }

    private fun loadNews() {

        RetrofitClient.instance.getNews()
            .enqueue(object : Callback<List<News>> {

                override fun onResponse(
                    call: Call<List<News>>,
                    response: Response<List<News>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            recyclerView.adapter = NewsAdapter(it.take(10))
                        }
                    }
                }

                override fun onFailure(call: Call<List<News>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }
}
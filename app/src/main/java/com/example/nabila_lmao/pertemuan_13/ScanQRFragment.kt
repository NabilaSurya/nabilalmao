package com.example.nabila_lmao.pertemuan_13

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nabila_lmao.R

class ScanQRFragment :
    Fragment(R.layout.fragment_scan_q_r) {

    private lateinit var previewView: PreviewView
    private lateinit var tvResult: TextView

    private val permissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {

            if (it)
                startCamera()

        }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view,savedInstanceState)

        previewView=view.findViewById(R.id.previewView)

        tvResult=view.findViewById(R.id.tvResult)

        if(

            ContextCompat.checkSelfPermission(

                requireContext(),

                Manifest.permission.CAMERA

            )

            == PackageManager.PERMISSION_GRANTED

        ){

            startCamera()

        }else{

            permissionLauncher.launch(

                Manifest.permission.CAMERA

            )

        }

    }

    private fun startCamera(){

        val providerFuture=

            ProcessCameraProvider.getInstance(

                requireContext()

            )

        providerFuture.addListener({

            val provider=providerFuture.get()

            val preview=Preview.Builder().build()

            preview.setSurfaceProvider(

                previewView.surfaceProvider

            )

            val analyzer=

                ImageAnalysis.Builder()

                    .build()

            analyzer.setAnalyzer(

                ContextCompat.getMainExecutor(requireContext()),

                BarcodeAnalyzer{

                    tvResult.text=it

                }

            )

            provider.unbindAll()

            provider.bindToLifecycle(

                viewLifecycleOwner,

                CameraSelector.DEFAULT_BACK_CAMERA,

                preview,

                analyzer

            )

        },

            ContextCompat.getMainExecutor(requireContext())

        )

    }

}
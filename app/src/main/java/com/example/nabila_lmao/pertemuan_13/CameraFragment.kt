package com.example.nabila_lmao.pertemuan_13

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.nabila_lmao.R
import com.google.android.material.button.MaterialButton
import java.io.File

class CameraFragment :
    Fragment(R.layout.fragment_camera) {

    private lateinit var imgPreview: ImageView

    private lateinit var imageUri: Uri

    private lateinit var imageFile: File

    private val cameraLauncher =
        registerForActivityResult(
            ActivityResultContracts.TakePicture()
        ) { success ->

            if (success) {

                imgPreview.setImageURI(imageUri)

            }

        }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        imgPreview =
            view.findViewById(R.id.imgPreview)

        val btn =
            view.findViewById<MaterialButton>(R.id.btnCamera)

        btn.setOnClickListener {

            val pair =
                FileUtil.createImageUri(requireContext())

            imageFile = pair.first

            imageUri = pair.second

            cameraLauncher.launch(imageUri)

        }

    }

}
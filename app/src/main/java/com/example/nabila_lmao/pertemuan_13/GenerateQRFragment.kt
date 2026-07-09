package com.example.nabila_lmao.pertemuan_13

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nabila_lmao.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

class GenerateQRFragment :
    Fragment(R.layout.fragment_generate_q_r) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        val etQR =
            view.findViewById<TextInputEditText>(R.id.etQR)

        val imgQR =
            view.findViewById<ImageView>(R.id.imgQR)

        val btn =
            view.findViewById<MaterialButton>(R.id.btnGenerateQR)

        btn.setOnClickListener {

            val text =
                etQR.text.toString()

            if(text.isEmpty()){

                Toast.makeText(
                    requireContext(),
                    "Masukkan data terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            imgQR.setImageBitmap(
                generateQRCode(text)
            )

        }

    }

    private fun generateQRCode(
        text:String
    ):Bitmap{

        val writer=QRCodeWriter()

        val bitMatrix=writer.encode(
            text,
            BarcodeFormat.QR_CODE,
            600,
            600
        )

        val width=bitMatrix.width
        val height=bitMatrix.height

        val bitmap=Bitmap.createBitmap(
            width,
            height,
            Bitmap.Config.RGB_565
        )

        for(x in 0 until width){

            for(y in 0 until height){

                bitmap.setPixel(

                    x,
                    y,

                    if(bitMatrix[x,y])
                        Color.BLACK
                    else
                        Color.WHITE

                )

            }

        }

        return bitmap

    }

}
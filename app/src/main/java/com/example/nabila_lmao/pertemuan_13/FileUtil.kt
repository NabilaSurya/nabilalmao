package com.example.nabila_lmao.pertemuan_13

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileUtil {

    fun createImageUri(
        context: Context
    ): Pair<File, Uri> {

        val timeStamp = SimpleDateFormat(
            "yyyyMMdd_HHmmss",
            Locale.getDefault()
        ).format(Date())

        val imageFile = File(

            context.getExternalFilesDir("Pictures"),

            "BINADESA_$timeStamp.jpg"

        )

        val uri = FileProvider.getUriForFile(

            context,

            "${context.packageName}.provider",

            imageFile

        )

        return Pair(imageFile, uri)

    }

}
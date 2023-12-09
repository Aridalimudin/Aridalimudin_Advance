package com.example.aridalimudin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GmapsActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gmaps)

        val lokasi: EditText = findViewById(R.id.lokasi)
        lokasi.setOnClickListener(this)

        val tujuan: EditText = findViewById(R.id.tujuan)
        tujuan.setOnClickListener(this)

        val maps: Button = findViewById(R.id.maps)
        maps.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val editTextSource = findViewById<EditText>(R.id.lokasi)
        val editTextDestination = findViewById<EditText>(R.id.tujuan)

        val lokasi = editTextSource.text.toString()
        val tujuan = editTextDestination.text.toString()
        if (lokasi == "" && tujuan == "") {
            Toast.makeText(
                this@GmapsActivity,
                "Input Lokasi dan Tujuan anda",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val uri = Uri.parse("https://www.google.com/maps/dir/$lokasi/$tujuan")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
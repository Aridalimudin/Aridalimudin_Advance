package com.example.aridalimudin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class BioActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        val ig: ImageView = findViewById(R.id.ig)
        ig.setOnClickListener(this)

        val fb: ImageView = findViewById(R.id.fb)
        fb.setOnClickListener(this)

        val tiktok: ImageView = findViewById(R.id.tiktok)
        tiktok.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ig -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ar22id_"))
                startActivity(intent)
            }

            R.id.fb -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100070457084364&mibextid=ZbWKwl"))
                startActivity(intent)
            }

            R.id.tiktok -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/@aridal22"))
                startActivity(intent)
            }
        }
    }
}
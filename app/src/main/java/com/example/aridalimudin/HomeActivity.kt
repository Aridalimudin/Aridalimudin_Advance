package com.example.aridalimudin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val data: Button = findViewById(R.id.data)
        data.setOnClickListener(this)

        val gmaps: TextView = findViewById(R.id.gmaps)
        gmaps.setOnClickListener(this)

        val input: TextView = findViewById(R.id.input)
        input.setOnClickListener(this)

        tv =findViewById(R.id.txt_1)

        val username = intent.getParcelableExtra<user>("username")
        val password = intent.getParcelableExtra<user>("password")
        tv.text = "username: $username dan password: $password"
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.data -> {
                val intent = Intent(this@HomeActivity, BioActivity::class.java)
                startActivity(intent)
            }

            R.id.gmaps -> {
                val intent = Intent(this@HomeActivity, GmapsActivity::class.java)
                startActivity(intent)
            }
            R.id.input -> {
                val intent = Intent(this@HomeActivity, MahasiswaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
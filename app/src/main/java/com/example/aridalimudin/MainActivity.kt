package com.example.aridalimudin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var username:EditText
    private lateinit var pw:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        pw = findViewById(R.id.pw)

        val bundle = intent.extras
        if (bundle != null) {
            username.setText(bundle.getString("username"))
            pw.setText(bundle.getString("password"))
        }

        val btn_masuk1: Button = findViewById(R.id.btn_masuk1)
        btn_masuk1.setOnClickListener(this)

        val btn_daftar: TextView = findViewById(R.id.btn_daftar)
        btn_daftar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_masuk1 -> {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("user",user(username.text.toString(), pw.text.toString()))
                startActivity(intent)
            }

            R.id.btn_daftar -> {
                val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

    }
}

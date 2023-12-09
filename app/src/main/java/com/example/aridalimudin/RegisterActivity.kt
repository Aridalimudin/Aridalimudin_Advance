package com.example.aridalimudin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var nama: EditText
    private lateinit var username1: EditText
    private lateinit var pw1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nama = findViewById(R.id.nama)
        username1 = findViewById(R.id.username1)
        pw1 = findViewById(R.id.pw1)

        val btn_daftar1: Button = findViewById(R.id.btn_daftar1)
        btn_daftar1.setOnClickListener(this)

        val btn_masuk: TextView = findViewById(R.id.btn_masuk)
        btn_masuk.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_daftar1 -> {

                val bundle = Bundle()
                bundle.putString("username", username1.text.toString())
                bundle.putString("password", pw1.text.toString())

                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            R.id.btn_masuk -> {
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}

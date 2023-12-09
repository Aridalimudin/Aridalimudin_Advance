package com.example.aridalimudin

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahActivity : AppCompatActivity() {

    private lateinit var cursor: Cursor
    private lateinit var database: Database
    private lateinit var btnTambah: Button
    private lateinit var nama: EditText
    private lateinit var jurusan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        database = Database(this)
        nama = findViewById(R.id.nama)
        jurusan = findViewById(R.id.jurusan)
        btnTambah = findViewById(R.id.btn_tambah)

        btnTambah.setOnClickListener {
            val db: SQLiteDatabase = database.writableDatabase
            db.execSQL(
                "INSERT INTO mahasiswa (nama, jurusan) VALUES ('" +
                        "${nama.text.toString()}','${jurusan.text.toString()}')"
            )
            Toast.makeText(this@TambahActivity, "Data Tersimpan", Toast.LENGTH_SHORT).show()
            MahasiswaActivity.mahasiswaActivity?.refreshList()
            finish()
        }
    }
}

package com.example.aridalimudin

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var cursor: Cursor
    private lateinit var database: Database
    private lateinit var btnDetail: Button
    private lateinit var nama: TextView
    private lateinit var jurusan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        database = Database(this)
        nama = findViewById(R.id.nama)
        jurusan = findViewById(R.id.jurusan)
        btnDetail = findViewById(R.id.btn_detail)

        val db: SQLiteDatabase = database.readableDatabase
        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama='" +
                intent.getStringExtra("nama") + "'", null)
        cursor.moveToPosition(0)
        nama.text = cursor.getString(0).toString()
        jurusan.text = cursor.getString(1).toString()
    }
}

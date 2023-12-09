package com.example.aridalimudin

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UbahActivity : AppCompatActivity() {

    private lateinit var cursor: Cursor
    private lateinit var database: Database
    private lateinit var btnUbah: Button
    private lateinit var nama: EditText
    private lateinit var jurusan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah)

        database = Database(this)
        nama = findViewById(R.id.nama)
        jurusan = findViewById(R.id.jurusan)
        btnUbah = findViewById(R.id.btn_ubah)
        val db: SQLiteDatabase = database.readableDatabase

        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama = '" +
                intent.getStringExtra("nama") + "'", null)
        cursor.moveToFirst()
        if (cursor.count > 0) {
            cursor.moveToPosition(0)
            nama.setText(cursor.getString(0).toString())
            jurusan.setText(cursor.getString(1).toString())
        }

        btnUbah.setOnClickListener(View.OnClickListener {
            val db: SQLiteDatabase = database.writableDatabase
            db.execSQL("update mahasiswa set nama='" +
                    nama.text.toString() + "', jurusan= '" +
                    jurusan.text.toString() + "'where nama ='" +
                    intent.getStringExtra("nama") + "'")
            Toast.makeText(this@UbahActivity, "Data berhasil diubah", Toast.LENGTH_SHORT).show()
            MahasiswaActivity.mahasiswaActivity?.refreshList()
            finish()
        })
    }
}

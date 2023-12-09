package com.example.aridalimudin

import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MahasiswaActivity : AppCompatActivity() {

    private var daftar: Array<String>? = null
    private var listView: ListView? = null
    private var menu: Menu? = null
    private var cursor: Cursor? = null
    private var database: Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val pindah = Intent(this@MahasiswaActivity, TambahActivity::class.java)
            startActivity(pindah)
        }
        mahasiswaActivity = this
        database = Database(this)
        refreshList()
    }

    fun refreshList() {
        val db: SQLiteDatabase = database!!.readableDatabase
        cursor = db.rawQuery("SELECT * FROM mahasiswa", null)
        cursor!!.moveToFirst()
        for (i in 0 until cursor!!.count) {
            cursor!!.moveToPosition(i)
            daftar!![i] = cursor!!.getString(0).toString()
        }
        listView = findViewById(R.id.listView)
        listView!!.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar!!)
        listView!!.isSelected = true
        listView!!.onItemClickListener = AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val selection = daftar!![arg2]
            val dialogitem = arrayOf<CharSequence>("Lihat Mahasiswa", "Update Mahasiswa", "Hapus Mahasiswa")
            val builder = AlertDialog.Builder(this@MahasiswaActivity)
            builder.setTitle("Pilihan")
            builder.setItems(dialogitem, DialogInterface.OnClickListener { dialog, item ->
                when (item) {
                    0 -> {
                        val i = Intent(applicationContext, DetailActivity::class.java)
                        i.putExtra("nama", selection)
                        startActivity(i)
                    }
                    1 -> {
                        val `in` = Intent(applicationContext, UbahActivity::class.java)
                        `in`.putExtra("nama", selection)
                        startActivity(`in`)
                    }
                    2 -> {
                        val db = database!!.writableDatabase
                        db.execSQL("delete from mahasiswa where nama = '$selection'")
                        refreshList()
                    }
                }
            })
            builder.create().show()
        }
        (listView!!.adapter as ArrayAdapter<*>).notifyDataSetInvalidated()
    }

    companion object {
        var mahasiswaActivity: MahasiswaActivity? = null
    }
}
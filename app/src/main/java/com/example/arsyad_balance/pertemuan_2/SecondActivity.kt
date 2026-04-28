package com.example.arsyad_balance.pertemuan_2

import android.os.Bundle
import android.widget.*
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arsyad_balance.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // 🔙 TOMBOL KEMBALI
        val btnKembali = findViewById<LinearLayout>(R.id.btnKembali)
        btnKembali.setOnClickListener {
            finish()
        }

        // SEGITIGA
        val etAlas = findViewById<EditText>(R.id.etAlas)
        val etTinggiSegitiga = findViewById<EditText>(R.id.etTinggiSegitiga)
        val btnHitungLuas = findViewById<Button>(R.id.btnHitungLuas)
        val tvHasilLuas = findViewById<TextView>(R.id.tvHasilLuas)

        // BALOK
        val etPanjang = findViewById<EditText>(R.id.etPanjang)
        val etLebar = findViewById<EditText>(R.id.etLebar)
        val etTinggiBalok = findViewById<EditText>(R.id.etTinggiBalok)
        val btnHitungVolume = findViewById<Button>(R.id.btnHitungVolume)
        val tvHasilVolume = findViewById<TextView>(R.id.tvHasilVolume)

        // LUAS SEGITIGA
        btnHitungLuas.setOnClickListener {
            val alas = etAlas.text.toString()
            val tinggi = etTinggiSegitiga.text.toString()

            if (alas.isEmpty() || tinggi.isEmpty()) {
                tvHasilLuas.text = "Input tidak boleh kosong!"
            } else {
                val hasil = 0.5 * alas.toDouble() * tinggi.toDouble()
                tvHasilLuas.text = "Luas Segitiga: $hasil"
            }
        }

        // VOLUME BALOK
        btnHitungVolume.setOnClickListener {
            val p = etPanjang.text.toString()
            val l = etLebar.text.toString()
            val t = etTinggiBalok.text.toString()

            if (p.isEmpty() || l.isEmpty() || t.isEmpty()) {
                tvHasilVolume.text = "Input tidak boleh kosong!"
            } else {
                val hasil = p.toDouble() * l.toDouble() * t.toDouble()
                tvHasilVolume.text = "Volume Balok: $hasil"
            }
        }
    }
}
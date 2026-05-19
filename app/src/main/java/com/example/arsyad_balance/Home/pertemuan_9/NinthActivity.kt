package com.example.arsyad_balance.Home.pertemuan_9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.arsyad_balance.databinding.ActivityNinthBinding

class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Padding untuk System Bars (SUDAH DIPERBAIKI)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Angka 0 diubah menjadi systemBars.top agar tidak nabrak status bar
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // 1. ChipGroup logic
        binding.chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                Toast.makeText(this, "Kategori terpilih", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. MaterialButton logic
        binding.btnSimpan.setOnClickListener {
            val kegiatan = binding.etKegiatan.text.toString()
            if (kegiatan.isNotEmpty()) {
                Toast.makeText(this, "Kegiatan $kegiatan disimpan!", Toast.LENGTH_SHORT).show()
            } else {
                binding.etKegiatan.error = "Nama kegiatan tidak boleh kosong"
            }
        }
    }
}
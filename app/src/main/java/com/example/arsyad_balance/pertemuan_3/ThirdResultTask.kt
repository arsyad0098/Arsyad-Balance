package com.example.arsyad_balance.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.arsyad_balance.R
import com.example.arsyad_balance.pertemuan_2.SecondActivity
import com.example.arsyad_balance.pertemuan_4.Custom1Activity
import com.example.arsyad_balance.pertemuan_4.Custom2Activity
import com.google.android.material.snackbar.Snackbar

class ThirdResultTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_result_task)

        val btnBangunRuang = findViewById<Button>(R.id.btnBangunRuang)
        val btnCustom1 = findViewById<Button>(R.id.btnCustom1)
        val btnCustom2 = findViewById<Button>(R.id.btnCustom2)
        val btnLogout = findViewById<Button>(R.id.btnMenuKeluar)

        // Bangun Ruang
        btnBangunRuang.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // Custom 1
        btnCustom1.setOnClickListener {
            startActivity(Intent(this, Custom1Activity::class.java))
        }

        // Custom 2
        btnCustom2.setOnClickListener {
            startActivity(Intent(this, Custom2Activity::class.java))
        }

        // 🔥 LOGOUT (yang ditambahkan)
        btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah kamu yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    val intent = Intent(this, ThirdTaskActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(findViewById(android.R.id.content), "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}
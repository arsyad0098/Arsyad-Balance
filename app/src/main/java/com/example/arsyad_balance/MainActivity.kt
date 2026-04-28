package com.example.arsyad_balance

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.arsyad_balance.pertemuan_2.SecondActivity
import com.example.arsyad_balance.pertemuan_4.Custom1Activity
import com.example.arsyad_balance.pertemuan_4.Custom2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Setup Buttons
        val btnBangunRuang = findViewById<Button>(R.id.btnBangunRuang)
        val btnCustom1 = findViewById<Button>(R.id.btnCustom1)
        val btnCustom2 = findViewById<Button>(R.id.btnCustom2)
        val btnWebView = findViewById<Button>(R.id.btnWebView)
        val ivLogout = findViewById<ImageView>(R.id.ivLogout)

        btnBangunRuang.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        btnCustom1.setOnClickListener {
            startActivity(Intent(this, Custom1Activity::class.java))
        }

        btnCustom2.setOnClickListener {
            startActivity(Intent(this, Custom2Activity::class.java))
        }

        btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        ivLogout.setOnClickListener {
            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogin", false)
            editor.apply()

            Toast.makeText(this, "Berhasil Logout", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, BinaDesaActivity::class.java))
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
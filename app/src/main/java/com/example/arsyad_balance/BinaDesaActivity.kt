package com.example.arsyad_balance

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BinaDesaActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bina_desa)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        
        btnLogin.setOnClickListener {
            // Simulasi login berhasil
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogin", true)
            editor.apply()

            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
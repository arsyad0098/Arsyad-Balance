package com.example.arsyad_balance

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class VerificationActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_verification)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val etOtp = findViewById<EditText>(R.id.etOtp)
        val btnVerify = findViewById<AppCompatButton>(R.id.btnVerify)

        // Ambil data dari Intent
        val name = intent.getStringExtra("NAME")
        val email = intent.getStringExtra("EMAIL")
        val phone = intent.getStringExtra("PHONE")
        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")

        btnVerify.setOnClickListener {
            val inputOtp = etOtp.text.toString()

            if (inputOtp.isEmpty()) {
                showErrorDialog("OTP tidak boleh kosong")
            } else if (inputOtp == phone) {
                // Berhasil: Simpan ke SharedPreferences
                saveToSharedPrefs(name, email, phone, username, password)
                
                Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, BinaDesaActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            } else {
                showErrorDialog("Kode OTP salah. OTP harus sama dengan nomor handphone.")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showErrorDialog(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Gagal Verifikasi")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun saveToSharedPrefs(name: String?, email: String?, phone: String?, user: String?, pass: String?) {
        val editor = sharedPreferences.edit()
        editor.putString("savedName", name)
        editor.putString("savedEmail", email)
        editor.putString("savedPhone", phone)
        editor.putString("savedUsername", user)
        editor.putString("savedPassword", pass)
        editor.apply()
    }
}
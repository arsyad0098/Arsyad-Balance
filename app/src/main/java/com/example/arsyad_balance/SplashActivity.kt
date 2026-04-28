package com.example.arsyad_balance

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val isLogin = sharedPreferences.getBoolean("isLogin", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin) {
                // Jika sudah login, langsung ke MainActivity
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Jika belum login, ke halaman BinaDesaActivity (Login)
                startActivity(Intent(this, BinaDesaActivity::class.java))
            }
            finish()
        }, 1500)
    }
}
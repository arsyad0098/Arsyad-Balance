package com.example.arsyad_balance

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.arsyad_balance.Message.tutorial.TutorialMessageActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            // PAKSA KE ONBOARDING DULU SETIAP KALI RUN (Biar enak ngetesnya)
            startActivity(Intent(this, TutorialMessageActivity::class.java))
            finish()
        }, 1500)
    }
}
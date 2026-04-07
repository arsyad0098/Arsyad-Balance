package com.example.arsyad_balance.pertemuan_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arsyad_balance.databinding.ActivityThirdTaskBinding

class ThirdTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val intent = Intent(this, ThirdResultTask::class.java)
            startActivity(intent)
        }
    }
}
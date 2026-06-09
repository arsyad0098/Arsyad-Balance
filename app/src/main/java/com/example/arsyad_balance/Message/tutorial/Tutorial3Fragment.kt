package com.example.arsyad_balance.Message.tutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.arsyad_balance.BinaDesaActivity
import com.example.arsyad_balance.R

class Tutorial3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial3, container, false)

        val btnMulai = view.findViewById<Button>(R.id.btnMulai)
        btnMulai.setOnClickListener {
            val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("isOnboardingFinished", true).apply()

            // PINDAH KE HALAMAN LOGIN (BinaDesaActivity)
            val intent = Intent(requireActivity(), BinaDesaActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}
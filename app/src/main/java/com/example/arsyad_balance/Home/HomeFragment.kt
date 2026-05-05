package com.example.arsyad_balance.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.arsyad_balance.BinaDesaActivity
import com.example.arsyad_balance.WebViewActivity
import com.example.arsyad_balance.Home.pertemuan_2.SecondActivity
import com.example.arsyad_balance.Home.pertemuan_4.Custom1Activity
import com.example.arsyad_balance.Home.pertemuan_4.Custom2Activity
import com.example.arsyad_balance.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar sebagai ActionBar (Sesuai Instruksi Foto)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        // Setup event click menggunakan binding
        binding.apply {
            // Intent ke SecondActivity dengan Extra (Sesuai Instruksi Foto)
            btnBangunRuang.setOnClickListener {
                val intent = Intent(requireContext(), SecondActivity::class.java)
                intent.putExtra("judul", "Pertemuan 2")
                startActivity(intent)
            }

            btnCustom1.setOnClickListener {
                startActivity(Intent(requireContext(), Custom1Activity::class.java))
            }

            btnCustom2.setOnClickListener {
                startActivity(Intent(requireContext(), Custom2Activity::class.java))
            }

            btnWebView.setOnClickListener {
                startActivity(Intent(requireContext(), WebViewActivity::class.java))
            }

            ivLogout.setOnClickListener {
                val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLogin", false)
                editor.apply()

                Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()
                startActivity(Intent(requireContext(), BinaDesaActivity::class.java))
                requireActivity().finish()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
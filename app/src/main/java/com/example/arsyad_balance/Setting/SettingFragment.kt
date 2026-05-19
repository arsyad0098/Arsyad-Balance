package com.example.arsyad_balance.Settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arsyad_balance.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val settingList = listOf(
        SettingModel("Profil Saya", "Atur informasi data diri dan desa", android.R.drawable.ic_menu_myplaces),
        SettingModel("Notifikasi", "Pengaturan nada dering dan pengingat", android.R.drawable.ic_popup_reminder),
        SettingModel("Privacy Policy", "Kebijakan privasi pengguna aplikasi", android.R.drawable.ic_secure),
        SettingModel("Terms of Service", "Syarat dan ketentuan Bina Desa", android.R.drawable.ic_menu_agenda),
        SettingModel("Bantuan & Dukungan", "Hubungi admin jika ada kendala", android.R.drawable.ic_menu_help),
        SettingModel("Tentang Aplikasi", "Versi Bina Desa 1.0.0", android.R.drawable.ic_menu_info_details)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = "Settings"

        val adapter = SettingAdapter(requireContext(), settingList)
        binding.listSettingItems.adapter = adapter
    }
}
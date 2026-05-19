package com.example.arsyad_balance.Settings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.arsyad_balance.databinding.ItemSettingBinding
import com.google.android.material.snackbar.Snackbar

class SettingAdapter(
    context: Context,
    private val settings: List<SettingModel>
) : ArrayAdapter<SettingModel>(context, 0, settings) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemSettingBinding = ItemSettingBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = settings[position]

        binding.iconSetting.setImageResource(data.iconResId)
        binding.textTitle.text = data.title
        binding.textSubtitle.text = data.description

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Membuka menu: ${data.title}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        return view
    }
}
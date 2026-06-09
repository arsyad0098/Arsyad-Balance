package com.example.arsyad_balance.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arsyad_balance.BinaDesaActivity
import com.example.arsyad_balance.WebViewActivity
import com.example.arsyad_balance.Home.pertemuan_2.SecondActivity
import com.example.arsyad_balance.Home.pertemuan_4.Custom1Activity
import com.example.arsyad_balance.Home.pertemuan_4.Custom2Activity
import com.example.arsyad_balance.Home.pertemuan_9.NinthActivity
import com.example.arsyad_balance.data.api.ApiClient
import com.example.arsyad_balance.data.model.NewsPost
import com.example.arsyad_balance.data.model.NewsResponse
import com.example.arsyad_balance.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        setupRecyclerView()

        binding.apply {

            btnBerita.setOnClickListener {
                tvBeritaHeader.visibility = View.VISIBLE
                progressBar.visibility = View.VISIBLE
                rvNews.visibility = View.GONE
                fetchNews()
            }

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

            btnPertemuan9.setOnClickListener {
                startActivity(Intent(requireContext(), NinthActivity::class.java))
            }

            ivLogout.setOnClickListener {
                val sharedPreferences = requireActivity()
                    .getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                sharedPreferences.edit()
                    .putBoolean("isLogin", false)
                    .apply()

                Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()
                startActivity(Intent(requireContext(), BinaDesaActivity::class.java))
                requireActivity().finish()
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun fetchNews() {
        ApiClient.apiService.getNews().enqueue(object : Callback<NewsResponse> {

            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                if (_binding == null) return
                binding.progressBar.visibility = View.GONE

                if (response.isSuccessful) {
                    val newsList = response.body()?.data ?: emptyList<NewsPost>()

                    // Tambahkan log ini untuk lihat isi data pertama
                    if (newsList.isNotEmpty()) {
                        val first = newsList[0]
                        Log.d("HomeFragment", "=== CEK FIELD ===")
                        Log.d("HomeFragment", "title     : ${first.title}")
                        Log.d("HomeFragment", "description: ${first.description}")
                        Log.d("HomeFragment", "thumbnail : ${first.thumbnail}")
                        Log.d("HomeFragment", "link      : ${first.link}")
                        Log.d("HomeFragment", "pubDate   : ${first.pubDate}")
                    }

                    if (newsList.isEmpty()) {
                        Toast.makeText(requireContext(), "Data berita kosong", Toast.LENGTH_SHORT).show()
                        binding.rvNews.visibility = View.GONE
                    } else {
                        binding.rvNews.adapter = NewsAdapter(newsList)
                        binding.rvNews.visibility = View.VISIBLE
                        binding.scrollViewHome.post {
                            binding.scrollViewHome.smoothScrollTo(0, binding.tvBeritaHeader.top)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                if (_binding == null) return
                binding.progressBar.visibility = View.GONE
                binding.rvNews.visibility = View.GONE

                Log.e("HomeFragment", "onFailure: ${t.javaClass.simpleName} - ${t.message}")
                Toast.makeText(
                    requireContext(),
                    "Koneksi gagal: ${t.javaClass.simpleName}\n${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

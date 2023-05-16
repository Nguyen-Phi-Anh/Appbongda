package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appbongda.databinding.ActivityMainBinding
import com.example.appbongda.databinding.ActivityRankingBinding

private lateinit var binding: ActivityRankingBinding
class Ranking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.detailAnh.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Ranking, DetailRank::class.java)
            startActivity(intent)
        })
        binding.detailDuc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Ranking, DetailRank::class.java)
            startActivity(intent)
        })
        binding.detailPhap.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Ranking, DetailRank::class.java)
            startActivity(intent)
        })
        binding.DetailTay.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Ranking, DetailRank::class.java)
            startActivity(intent)
        })
    }
}
package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appbongda.databinding.ActivityGiaidaungoaihangBinding
import com.example.appbongda.databinding.ActivityRankingBinding

class giaidau : AppCompatActivity() {
    private lateinit var binding: ActivityGiaidaungoaihangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiaidaungoaihangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.detailAnh.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@giaidau, ViewGiaidau::class.java)
            startActivity(intent)
        })
        binding.detailDuc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@giaidau, ViewGiaidau::class.java)
            startActivity(intent)
        })
        binding.detailPhap.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@giaidau, ViewGiaidau::class.java)
            startActivity(intent)
        })
        binding.DetailTay.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@giaidau, ViewGiaidau::class.java)
            startActivity(intent)
        })
    }
}
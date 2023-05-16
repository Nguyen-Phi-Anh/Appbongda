package com.example.appbongda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.appbongda.databinding.ActivityDetailCblBinding
import com.example.appbongda.databinding.ActivityDetailTranDauBinding

class DetailTranDau : AppCompatActivity() {
    var imageUrl = ""
    var imageUrl2 = ""
    private lateinit var binding: ActivityDetailTranDauBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTranDauBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
            binding.team1.text = bundle.getString("Team1")
            binding.team2.text = bundle.getString("Team2")
            binding.mota.text = bundle.getString("Mota")
            imageUrl = bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image"))
                .into(binding.imageButton)
            imageUrl2 = bundle.getString("Image2")!!
            Glide.with(this).load(bundle.getString("Image2"))
                .into(binding.imageButton2)
            val a = bundle.getString("Team1")
            val b = bundle.getString("Team2")
            val c = bundle.getString("Mota")
            val d = bundle.getString("Image")
            val e = bundle.getString("Image2")
        }
    }
}
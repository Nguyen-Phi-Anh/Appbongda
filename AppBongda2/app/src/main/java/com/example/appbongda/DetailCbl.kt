package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.appbongda.databinding.ActivityDetailBinding
import com.example.appbongda.databinding.ActivityDetailCblBinding

class DetailCbl : AppCompatActivity() {
    var imageUrl = ""
    var imageUrl2 = ""
    private lateinit var binding: ActivityDetailCblBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCblBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
            binding.detailmota.text = bundle.getString("Description")
            binding.detailName1.text = bundle.getString("Name")
            binding.detailTournament.text = bundle.getString("Tournament")
            imageUrl = bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image"))
                .into(binding.detailImage)
            imageUrl2 = bundle.getString("Image2")!!
            Glide.with(this).load(bundle.getString("Image2"))
                .into(binding.detailmage2)
            val a = bundle.getString("Name")
            val b = bundle.getString("Position")
            val c = bundle.getString("Tournament")
            val d = bundle.getString("Image")
            val e = bundle.getString("Image2")
        }
    }
}
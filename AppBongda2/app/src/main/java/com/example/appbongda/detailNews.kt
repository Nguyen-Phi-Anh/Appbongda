package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.appbongda.databinding.ActivityDetailBinding
import com.example.appbongda.databinding.ActivityDetailNewsBinding

class detailNews : AppCompatActivity() {
    var imageUrl = ""
    private lateinit var binding: ActivityDetailNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
            binding.detailTitle.text = bundle.getString("Title")
            binding.detailDesc3.text = bundle.getString("Description")
            imageUrl = bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image"))
                .into(binding.detailImage)
        }
    }
}
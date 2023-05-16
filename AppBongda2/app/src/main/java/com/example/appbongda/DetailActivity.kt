package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.appbongda.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    var imageUrl = ""
    var imageUrl2 = ""
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
//            binding.detailDesc.text = bundle.getString("Description")
            binding.detailName.text = bundle.getString("Name")
            binding.detailPosition.text = bundle.getString("Position")
            imageUrl = bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image"))
                .into(binding.detailImage)
            imageUrl2 = bundle.getString("Image2")!!
            Glide.with(this).load(bundle.getString("Image2"))
                .into(binding.detailImage2)
            val a = bundle.getString("Name")
            val b = bundle.getString("Position")
            val c = bundle.getString("Description")
            val d = bundle.getString("Image")
            val e = bundle.getString("Image2")
            binding.thongtin.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@DetailActivity, MainActivity::class.java)
                intent.putExtra("Name", a)
                intent.putExtra("Position", b)
                intent.putExtra("Description", c)
                intent.putExtra("Image", d)
                intent.putExtra("Image2", e)
                startActivity(intent)
            })
            binding.mota.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@DetailActivity, DetailActivity::class.java)
                intent.putExtra("Name", a)
                intent.putExtra("Position", b)
                intent.putExtra("Description", c)
                intent.putExtra("Image", d)
                intent.putExtra("Image2", e)
                startActivity(intent)
            })
            binding.tieusu.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@DetailActivity, mota::class.java)
                intent.putExtra("Name", a)
                intent.putExtra("Position", b)
                intent.putExtra("Description", c)
                intent.putExtra("Image", d)
                intent.putExtra("Image2", e)
                startActivity(intent)
            })
        }
    }
}
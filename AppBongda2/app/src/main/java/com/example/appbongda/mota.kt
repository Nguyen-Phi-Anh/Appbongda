package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide

import com.example.appbongda.databinding.ActivityMotaBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class mota : AppCompatActivity() {
    private lateinit var binding: ActivityMotaBinding
    private lateinit var databaseReference: DatabaseReference
    var imageUrl = ""
    var imageUrl2 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras

        if (bundle != null) {
            binding.detailName.text  = bundle.getString("Name")
            binding.detailDesc.text  = bundle.getString("Description")
            binding.detailPosition.text  = bundle.getString("Position")
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
                val intent = Intent(this@mota, MainActivity::class.java)
                intent.putExtra("Name", a)
                intent.putExtra("Position", b)
                intent.putExtra("Description", c)
                intent.putExtra("Image", d)
                intent.putExtra("Image2", e)
                startActivity(intent)
            })
            binding.mota.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@mota, DetailActivity::class.java)
                intent.putExtra("Name", a)
                intent.putExtra("Position", b)
                intent.putExtra("Description", c)
                intent.putExtra("Image", d)
                intent.putExtra("Image2", e)
                startActivity(intent)
            })
            binding.soluot.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@mota, mota::class.java)
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
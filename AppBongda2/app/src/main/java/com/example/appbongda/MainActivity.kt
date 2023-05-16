package com.example.appbongda


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.appbongda.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    val username = FirebaseAuth.getInstance().currentUser
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = username?.displayName
        val usernameTextView = findViewById<TextView>(R.id.username)
        usernameTextView.text = username
        binding.addplayer.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, addPlayer::class.java)
            startActivity(intent)
        })
        binding.tintuc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, viewNews::class.java)
            startActivity(intent)
        })
        binding.clb.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ViewClb::class.java)
            startActivity(intent)
        })
        binding.rank.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Ranking::class.java)
            startActivity(intent)
        })
        binding.trandau.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, giaidau::class.java)
            startActivity(intent)
        })
        binding.dangki.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, register::class.java)
            startActivity(intent)
        })
    }
    }


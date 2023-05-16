package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appbongda.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private  lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView6.setOnClickListener {
            val intent = Intent(this , register::class.java)
            startActivity(intent)
            binding.fabBack.setOnClickListener {
                val intent = Intent(this, register::class.java)
                startActivity(intent)
            }
        }

        binding.button3.setOnClickListener {
            val usernameoremail = binding.edtuseroremail.text.toString()
            val password = binding.edtpasslogn.text.toString()


            if (usernameoremail.isNotEmpty() && password.isNotEmpty() ){

                firebaseAuth.signInWithEmailAndPassword(usernameoremail , password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }


            }else{
                Toast.makeText(this, " Empty Fields are not allowed !!", Toast.LENGTH_SHORT)
            }
        }




    }
}
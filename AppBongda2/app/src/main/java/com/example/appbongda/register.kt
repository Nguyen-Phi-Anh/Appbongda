package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appbongda.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.button.setOnClickListener{
            val username = binding.edtusername.text.toString()
            val email = binding.edtemail.text.toString()
            val password = binding.edtpassword.text.toString()
            val confirpassword = binding.etdconfirmpass.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirpassword.isNotEmpty()){
                if (password == confirpassword){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, login ::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText( this, "Passwword is not matching" , Toast.LENGTH_SHORT ).show()
                }
            }else{
                Toast.makeText(this, " Empty Fields are not allowed !!", Toast.LENGTH_SHORT)
            }
        }
    }
}
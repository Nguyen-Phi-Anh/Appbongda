package com.example.appbongda

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.appbongda.databinding.ActivityUploadClbBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.text.DateFormat
import java.util.*


class UploadClb : AppCompatActivity() {
    private lateinit var binding: ActivityUploadClbBinding
    var imageURL: String? = null
    var uri: Uri? = null
    var imageURL2: String? = null
    var uri2: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadClbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val activityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                uri = data!!.data
                binding.uploadImage.setImageURI(uri)
            } else {
                Toast.makeText(this@UploadClb, "No Image Selected", Toast.LENGTH_SHORT).show()
            }
        }
        val activityResultLauncher2 = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data2 = result.data
                uri2 = data2!!.data
                binding.uploadImage2.setImageURI(uri2)
            } else {
                Toast.makeText(this@UploadClb, "No Image Selected", Toast.LENGTH_SHORT).show()
            }
        }
        binding.uploadImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }
        binding.uploadImage2.setOnClickListener {
            val photoPicker2 = Intent(Intent.ACTION_PICK)
            photoPicker2.type = "image/*"
            activityResultLauncher2.launch(photoPicker2)
        }
        binding.saveButton.setOnClickListener {
            saveData()
        }
    }
    private fun saveData(){
        val storageReference = FirebaseStorage.getInstance().reference.child("Task Images3")
            .child(uri!!.lastPathSegment!!)
        val builder = AlertDialog.Builder(this@UploadClb)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()
        storageReference.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
            val uriTask = taskSnapshot.storage.downloadUrl
            while (!uriTask.isComplete);
            val urlImage = uriTask.result
            imageURL = urlImage.toString()
            val storageReference2 = FirebaseStorage.getInstance().reference.child("Task Images4")
                .child(uri2!!.lastPathSegment!!)
            val builder2 = AlertDialog.Builder(this@UploadClb)
            builder2.setCancelable(false)
            builder2.setView(R.layout.progress_layout)
            val dialog2 = builder2.create()
            dialog.show()
            storageReference2.putFile(uri2!!).addOnSuccessListener { taskSnapshot ->
                val uriTask2 = taskSnapshot.storage.downloadUrl
                while (!uriTask2.isComplete);
                val urlImage2 = uriTask2.result
                imageURL2 = urlImage2.toString()
                uploadData()
                dialog.dismiss()
            }}.addOnFailureListener {
            dialog.dismiss()
        }
    }
    private fun uploadData(){
        val title = binding.uploadName.text.toString()
        val desc = binding.uploadDesc.text.toString()
        val priority = binding.uploadTournament.text.toString()
        val dataClass = DataClb(title, desc, priority, imageURL,imageURL2)
        val currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)
        FirebaseDatabase.getInstance().getReference("clb").child(currentDate)
            .setValue(dataClass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@UploadClb, "Saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }.addOnFailureListener { e ->
                Toast.makeText(
                    this@UploadClb, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}
package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appbongda.databinding.ActivityViewNewsBinding
import com.google.firebase.database.*
import kotlin.collections.ArrayList

class viewNews : AppCompatActivity() {
    var databaseReference: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var dataList: ArrayList<DataNews>
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityViewNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gridLayoutManager = GridLayoutManager(this@viewNews, 1)
        binding.recyclerView.layoutManager = gridLayoutManager

        val builder = AlertDialog.Builder(this@viewNews)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()

        dataList = ArrayList()
        adapter = NewsAdapter(this, dataList)
        binding.recyclerView.adapter = adapter
        databaseReference = FirebaseDatabase.getInstance().getReference("tintuc")
        dialog.show()

        eventListener = databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(DataNews::class.java)
                    if (dataClass != null) {
                        dataList.add(dataClass)
                    }
                }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
            }
        })
        binding.fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@viewNews, news::class.java)
            startActivity(intent)
        })

    }
}
package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appbongda.databinding.ActivityAddPlayerBinding
import com.example.appbongda.databinding.ActivityViewClbBinding
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class ViewClb : AppCompatActivity() {
    var databaseReference: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var dataList: ArrayList<DataClb>
    private lateinit var adapter: ClbAdapter
    private lateinit var binding: ActivityViewClbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewClbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gridLayoutManager = GridLayoutManager(this@ViewClb, 1)
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.search.clearFocus()
        val builder = AlertDialog.Builder(this@ViewClb)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()
        dataList = ArrayList()
        adapter = ClbAdapter(this@ViewClb, dataList)
        binding.recyclerView.adapter = adapter
        databaseReference = FirebaseDatabase.getInstance().getReference("clb")
        dialog.show()
        eventListener = databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(DataClb::class.java)
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
            val intent = Intent(this@ViewClb, UploadClb::class.java)
            startActivity(intent)
        })
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })
    }
    fun searchList(text: String) {
        val searchList = java.util.ArrayList<DataClb>()
        for (dataClass in dataList) {
            if (dataClass.dataName?.lowercase()
                    ?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }
}
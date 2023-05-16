package com.example.appbongda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appbongda.databinding.ActivityViewClbBinding
import com.example.appbongda.databinding.ActivityViewGiaidauBinding
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

class ViewGiaidau : AppCompatActivity() {
    var databaseReference: DatabaseReference? = null
    var eventListener: ValueEventListener? = null
    private lateinit var dataList: ArrayList<DataTranDau>
    private lateinit var adapter: TrandauAdapter
    private lateinit var binding: ActivityViewGiaidauBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewGiaidauBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gridLayoutManager = GridLayoutManager(this@ViewGiaidau, 1)
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.search.clearFocus()
        val builder = AlertDialog.Builder(this@ViewGiaidau)
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()
        dataList = ArrayList()
        adapter = TrandauAdapter(this@ViewGiaidau, dataList)
        binding.recyclerView.adapter = adapter
        databaseReference = FirebaseDatabase.getInstance().getReference("trandau")
        dialog.show()
        eventListener = databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(DataTranDau::class.java)
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
            val intent = Intent(this@ViewGiaidau, UploadTranDau::class.java)
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
        val searchList = java.util.ArrayList<DataTranDau>()
        for (dataClass in dataList) {
            if (dataClass.dataTeam1?.lowercase()
                    ?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }
}
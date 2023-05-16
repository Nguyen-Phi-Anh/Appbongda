package com.example.appbongda

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val context: Context, private var dataList: ArrayList<DataNews>) : RecyclerView.Adapter<MyViewHolder2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_new, parent, false)
        return MyViewHolder2(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
        Glide.with(context).load(dataList[position].dataImage)
            .into(holder.recImage)
        holder.recTitle.text = dataList[position].dataTitle
        holder.recDesc.text = dataList[position].dataDesc
        holder.recCard1.setOnClickListener {
            val intent = Intent(context, detailNews::class.java)
            intent.putExtra("Image", dataList[holder.adapterPosition].dataImage)
            intent.putExtra("Description", dataList[holder.adapterPosition].dataDesc)
            intent.putExtra("Title", dataList[holder.adapterPosition].dataTitle)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}
class MyViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recImage: ImageView
    var recTitle: TextView
    var recDesc: TextView
    var recCard1: CardView
    init {
        recImage = itemView.findViewById(R.id.recImage)
        recTitle = itemView.findViewById(R.id.recName)
        recDesc = itemView.findViewById(R.id.recTournament)
        recCard1 = itemView.findViewById(R.id.recCard1)
    }
}
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


class MyAdapter(private val context: Context, private var dataList: List<DataClass>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(dataList[position].dataImage)
            .into(holder.recImage)
        Glide.with(context).load(dataList[position].dataImage2)
            .into(holder.recImage2)
        holder.recName.text = dataList[position].dataName
//        holder.recDesc.text = dataList[position].dataDesc
        holder.recPosition.text = dataList[position].dataPosition
        holder.recCard.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("Image", dataList[holder.adapterPosition].dataImage)
            intent.putExtra("Image2", dataList[holder.adapterPosition].dataImage2)
            intent.putExtra("Description", dataList[holder.adapterPosition].dataDesc)
            intent.putExtra("Name", dataList[holder.adapterPosition].dataName)
            intent.putExtra("Position", dataList[holder.adapterPosition].dataPosition)
            context.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    fun searchDataList(searchList: List<DataClass>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recImage: ImageView
    var recImage2: ImageView
    var recName: TextView
    var recDesc: TextView
    var recPosition: TextView
    var recCard: CardView
    init {
        recImage = itemView.findViewById(R.id.recImage)
        recImage2 = itemView.findViewById(R.id.recImage2)
        recName = itemView.findViewById(R.id.recName)
        recDesc = itemView.findViewById(R.id.recDesc3)
        recPosition = itemView.findViewById(R.id.recTournament)
        recCard = itemView.findViewById(R.id.recCard1)
    }
}
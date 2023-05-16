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

class TrandauAdapter(private val context: Context, private var dataList: List<DataTranDau>) : RecyclerView.Adapter<MyViewHolder4>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder4 {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_trandau, parent, false)
        return MyViewHolder4(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder4, position: Int) {
        Glide.with(context).load(dataList[position].dataImage)
            .into(holder.recImage)
        Glide.with(context).load(dataList[position].dataImage2)
            .into(holder.recImage2)
        holder.recTeam1.text = dataList[position].dataTeam1
        holder.recDesc.text = dataList[position].dataMota
        holder.recTeam2.text = dataList[position].dataTeam2
        holder.recCard.setOnClickListener {
            val intent = Intent(context, DetailTranDau::class.java)
            intent.putExtra("Image", dataList[holder.adapterPosition].dataImage)
            intent.putExtra("Image2", dataList[holder.adapterPosition].dataImage2)
            intent.putExtra("Mota", dataList[holder.adapterPosition].dataMota)
            intent.putExtra("Team1", dataList[holder.adapterPosition].dataTeam1)
            intent.putExtra("Team2", dataList[holder.adapterPosition].dataTeam2
            )
            context.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    fun searchDataList(searchList: List<DataTranDau>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}
class MyViewHolder4(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recImage: ImageView
    var recImage2: ImageView
    var recTeam1: TextView
    var recDesc: TextView
    var recTeam2: TextView
    var recCard: CardView
    init {
        recImage = itemView.findViewById(R.id.recImage)
        recImage2 = itemView.findViewById(R.id.recImage2)
        recTeam1 = itemView.findViewById(R.id.recTeam1)
        recDesc = itemView.findViewById(R.id.recmota)
        recTeam2 = itemView.findViewById(R.id.recTeam2)
        recCard = itemView.findViewById(R.id.recCard1)
    }
}
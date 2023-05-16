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


class ClbAdapter(private val context: Context, private var dataList: List<DataClb>) : RecyclerView.Adapter<MyViewHolder3>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder3 {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_clb, parent, false)
        return MyViewHolder3(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder3, position: Int) {
        Glide.with(context).load(dataList[position].dataImage)
            .into(holder.recImage)
        Glide.with(context).load(dataList[position].dataImage2)
            .into(holder.recImage2)
        holder.recName.text = dataList[position].dataName
//        holder.recDesc.text = dataList[position].dataDesc
        holder.recTournament.text = dataList[position].dataTournament
        holder.recCard.setOnClickListener {
            val intent = Intent(context, DetailCbl::class.java)
            intent.putExtra("Image", dataList[holder.adapterPosition].dataImage)
            intent.putExtra("Image2", dataList[holder.adapterPosition].dataImage2)
            intent.putExtra("Description", dataList[holder.adapterPosition].dataDesc)
            intent.putExtra("Name", dataList[holder.adapterPosition].dataName)
            intent.putExtra("Tournament", dataList[holder.adapterPosition].dataTournament)
            context.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    fun searchDataList(searchList: List<DataClb>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}
class MyViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recImage: ImageView
    var recImage2: ImageView
    var recName: TextView
    var recDesc: TextView
    var recTournament: TextView
    var recCard: CardView
    init {
        recImage = itemView.findViewById(R.id.recImage)
        recImage2 = itemView.findViewById(R.id.recImage2)
        recName = itemView.findViewById(R.id.recName)
        recDesc = itemView.findViewById(R.id.recDesc3)
        recTournament = itemView.findViewById(R.id.recTournament)
        recCard = itemView.findViewById(R.id.recCard1)
    }
}
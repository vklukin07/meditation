package com.example.meditation.recycAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meditation.R


data class logins(val id:String, val email:String, val nickName:String, val avatar:String, val token:String)

data class feelings(val success:Boolean, val data:ArrayList<data_feelings>)
data class data_feelings(val id:Int, val title:String, val image:String, val position:Int)

data class quotes(val success: Boolean, val data:ArrayList<data_quotes>)
data class data_quotes(val id:Int, val title: String, val image: String, val description:String)

class FeelRecycler1(val context: Context, val feelings: feelings) : RecyclerView.Adapter<FeelRecycler1.MyVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelRecycler1.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.rv1_ad, parent, false)
        return MyVH(root)
    }

    class MyVH (itemView: View):RecyclerView.ViewHolder(itemView){
        val textDescr: TextView = itemView.findViewById(R.id.textView8)
        val imageV: ImageView = itemView.findViewById(R.id.imageView7)
    }

    override fun onBindViewHolder(holder: FeelRecycler1.MyVH, position: Int) {
        holder.textDescr.text = feelings.data[position].title
        Glide.with(context).load(feelings.data[position].image).into(holder.imageV)
    }

    override fun getItemCount(): Int {
        return feelings.data.size
    }

}

class FeelRecycler2(val context: Context, val quotes: quotes) : RecyclerView.Adapter<FeelRecycler2.MyVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelRecycler2.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.rv_adapter, parent, false)
        return MyVH(root)
    }

    class MyVH (itemView: View):RecyclerView.ViewHolder(itemView){
        val textViewBig: TextView = itemView.findViewById(R.id.title1)
        val textViewSmall: TextView = itemView.findViewById(R.id.description)
        val image:ImageView = itemView.findViewById(R.id.ad_image)
    }

    override fun onBindViewHolder(holder: FeelRecycler2.MyVH, position: Int) {
        holder.textViewBig.text = quotes.data[position].description
        holder.textViewSmall.text = quotes.data[position].title
        Glide.with(context).load(quotes.data[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return quotes.data.size
    }
}


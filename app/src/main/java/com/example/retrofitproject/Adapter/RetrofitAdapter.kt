package com.example.retrofitproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitproject.R
import com.example.retrofitproject.Activity.RetrofitActivity
import com.example.retrofitproject.RetrofitResponseItem

class RetrofitAdapter(
    var retrofitActivity: RetrofitActivity,
    var result: List<RetrofitResponseItem>,
    var onclick: (id: String,albumId  : String,title:String) -> Unit
) :
    RecyclerView.Adapter<RetrofitAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var txtId: TextView = itemView.findViewById(R.id.txtId)
        var CardLayout: CardView = itemView.findViewById(R.id.cardView)
        var txtAlbumId: TextView = itemView.findViewById(R.id.txtAlbumId)
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var imgView2: ImageView = itemView.findViewById(R.id.imgView2)
        var imgView: ImageView = itemView.findViewById(R.id.imgView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var View = LayoutInflater.from(retrofitActivity).inflate(R.layout.item_file, parent, false)
        return MyViewHolder(View)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtId.text = result.get(position).id.toString()
        holder.txtAlbumId.text = result.get(position).albumId.toString()
        holder.txtTitle.text = result.get(position).title.toString()

        holder.CardLayout.setOnClickListener {
            onclick.invoke(
                result[position].id!!.toInt().toString(),
                result[position].albumId!!.toInt().toString(),
                result[position].title!!.toString()
            )
        }


        Glide.with(retrofitActivity).load(result[position].url).into(holder.imgView)
        Glide.with(retrofitActivity).load(result[position].thumbnailUrl).into(holder.imgView2)

    }


    override fun getItemCount(): Int {
        return result.size

    }
}


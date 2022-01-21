package com.example.p

import com.example.phone.Inforamtion
import com.example.phone.R


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.phone.model.Cellphone
import java.util.ArrayList

class CellphoneAdapter(var cellphones: ArrayList<Cellphone>) :
    RecyclerView.Adapter<CellphoneAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cartview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.title.text  = cellphones[position].title

//        Glide.with(context).asBitmap().load(cellphones.get(position).getImageUrl()).into(holder.cellImage);
        holder.itemView.setOnClickListener { view ->
            val context=holder.title.context
            val intent = Intent(view.context, Inforamtion::class.java)
            intent.putExtra("phone", cellphones[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return cellphones.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cellImage: ImageView = itemView.findViewById(R.id.image_cart)
//        var infoImage: ImageView = itemView.findViewById(R.id.included)
        var title: TextView = itemView.findViewById(R.id.title_cart)
        var status: TextView = itemView.findViewById(R.id.status_cart)

    }


}
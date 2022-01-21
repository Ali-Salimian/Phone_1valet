package com.example.phone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.phone.model.Cellphone

class Inforamtion : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inforamtion)
        val cellphone: Cellphone = intent.getSerializableExtra("phone") as Cellphone
        val name = findViewById<TextView>(R.id.name_product)
        val size = findViewById<TextView>(R.id.size_product)
        val os = findViewById<TextView>(R.id.os_product)
        val status = findViewById<TextView>(R.id.status_product)
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val phoneName = findViewById<TextView>(R.id.phone_name)
        val phoneImage = findViewById<ImageView>(R.id.image_cell)
        phoneName?.text = cellphone.title
        size?.text = cellphone.size
        os?.text = cellphone.os
        status?.text = cellphone.status
        name?.text   = cellphone.title.toString()
        if (phoneImage != null) {
            Glide.with(applicationContext).asBitmap().load(cellphone.imageUrl).into(phoneImage)
        }
        backArrow?.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
package com.example.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.Klaxon
import com.example.p.CellphoneAdapter
import com.example.phone.model.Cellphone
import java.io.StringReader
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.cellphone_recycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val menu = findViewById<ImageView>(R.id.menu_icon)
        val searchBar = findViewById<EditText>(R.id.search_bar)
        val searchLin = findViewById<LinearLayout>(R.id.lin_search)
        val searchIcon = findViewById<ImageView>(R.id.search_icon)
        val closeSearch = findViewById<ImageView>(R.id.close)
        var search = ""
        searchLin.visibility = View.GONE


        //received json file
        val json1 = """
        {
        "data": [
            {"id": "1234","type": "Sensor","price": 20,"currency": "USD","isFavourite": false,"imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpM0nxWc4GO8h_Jny6a-_QtbQEt1eG4GrD1Q&usqp=CAU","title": "xiaomi z","description": "dfg","os":"android 10","size":"400*700","status":"available" },
            {"id": "1234","type": "Sensor","price": 20,"currency": "USD","isFavourite": false,"imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwLsR_jrk6pkcZ7TcEpVLujZd86PdGXS0gQg&usqp=CAU","title": "Sumsung note","description": "dfg","os":"android 10","size":"400*700","status":"available" },
            {"id": "1234","type": "Sensor","price": 20,"currency": "USD","isFavourite": false,"imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4dO770Kh7iMX_hP9DZuWyX9HaYcVCsV2Mug&usqp=CAU","title": "Sumsung s20","description": "dfg","os":"android 10","size":"400*700","status":"available" },
            {"id": "1234","type": "Sensor","price": 20,"currency": "USD","isFavourite": false,"imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9I27oXalR3L737MIrEmp7f1CH1PRhHxKbGw&usqp=CAU","title": "apple10","description": "dfg","os":"ios","size":"400*700","status":"available" },
            {"id": "1234","type": "Sensor","price": 20,"currency": "USD","isFavourite": false,"imageUrl": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9I27oXalR3L737MIrEmp7f1CH1PRhHxKbGw&usqp=CAU","title": "Sumsung10","description": "dfg","os":"android 10","size":"400*700","status":"available" },
            
        ],
        "otherdata" : "not needed"
        }
        """.trimIndent()

        // using Klaxon to parse JSOn file
        val klaxon = Klaxon()
        val parsed = klaxon.parseJsonObject(StringReader(json1))
        val dataArray = parsed.array<Any>("data")
        val cellphones = dataArray?.let { klaxon.parseFromJsonArray<Cellphone>(it) }
        val adapter = CellphoneAdapter(cellphones as ArrayList<Cellphone>)
        recyclerView.adapter = adapter


        // utilizing a custom activity to define menu
        menu.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(applicationContext, Pop::class.java)
            startActivity(intent1)
        })

        searchIcon.setOnClickListener(View.OnClickListener {

            if (searchLin.visibility == View.GONE) {
                searchLin.visibility =View.VISIBLE
            } else {
                 search = searchBar.getText().toString()
                val searchedPhone:ArrayList<Cellphone> = ArrayList()
                for(i in 0 until cellphones.size) {
                    if (cellphones[i].title.toString().contains(search,ignoreCase = true)) {
                        searchedPhone.add(cellphones[i])
                        Log.i( "search","onCreate: "+searchedPhone.size)
                    }
                }
                val adapter = CellphoneAdapter(searchedPhone)
                recyclerView.adapter = adapter
            }
        })

        closeSearch.setOnClickListener(View.OnClickListener {
            searchLin.visibility = View.GONE
            val cellphones = dataArray?.let { klaxon.parseFromJsonArray<Cellphone>(it) }
            val adapter = CellphoneAdapter(cellphones as ArrayList<Cellphone>)
            recyclerView.adapter = adapter
        })







    }




}
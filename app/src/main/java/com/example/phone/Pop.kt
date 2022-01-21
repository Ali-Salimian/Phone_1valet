package com.example.phone

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager

class Pop : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * .7).toInt(), (height * .96).toInt())
        val wlp = window.attributes
        wlp.gravity = Gravity.LEFT or Gravity.BOTTOM
        window.attributes = wlp
    }
}
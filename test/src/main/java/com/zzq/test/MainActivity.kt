package com.zzq.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.zzq.test.models.MainModel

class MainActivity : AppCompatActivity() {
    private val mainModel = MainModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMain = findViewById<TextView>(R.id.tv_main)
        tvMain.text =  mainModel.createTestString(10)
    }
}
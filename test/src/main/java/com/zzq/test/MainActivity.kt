package com.zzq.test

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zzq.test.models.MainModel
import com.zzq.test.utils.SpUtil

class MainActivity : AppCompatActivity() {
    private val mainModel = MainModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMain = findViewById<TextView>(R.id.tv_main)
        tvMain.text =  mainModel.createTestString(10)

        SpUtil.saveData(this, "LaunchTime", System.currentTimeMillis().toString())
        Log.e("test-tetetetete", "sp storeData,key is LaunchTime, value is :" +SpUtil.getData(this, "LaunchTime")?:"null")
    }
}
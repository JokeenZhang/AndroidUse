package com.zzq.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zzq.view.customview.CustomViewActivity
import com.zzq.view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
        binding.btnBtn1.text = generateData()
    }

    private fun generateData(): String {

        val applicationInfo = applicationInfo
        val packageManager = packageManager

        val packageInfo = packageManager.getPackageInfo(packageName, 0)

        return "Main: \n" +
                "packageName: ${applicationInfo.packageName}\n" +
                "versionName: ${packageInfo.versionName}\n" +
                "versionCode: ${packageInfo.versionCode}"
    }

    private fun initView() {
        binding.clickListener1 = View.OnClickListener {
            startActivity(Intent(this, CustomViewActivity::class.java))
        }
        binding.clickListener2 = View.OnClickListener {
            startActivity(Intent(this, CustomViewActivity::class.java))
        }
    }
}

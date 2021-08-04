package com.zzq.dialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zzq.common.interfaces.ClickProxy
import com.zzq.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        binding.singleChoiceListener = ClickProxy {
            SingleChoiceDialogFragment().show(supportFragmentManager, "first")
        }

        binding.btn2ClickListener = ClickProxy {
            AlertDialog.Builder(this).setTitle("viewId:btn2")
                .setMessage("展示Message，看看长什么样")
                .setCancelable(false)
                .setNegativeButton("取消") { dialog, which ->
                    Toast.makeText(this, "点击取消", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setPositiveButton("确定") { dialog, which ->
                    Toast.makeText(this, "点击确定", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .show()
        }
    }
}

package com.zzq.animator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zzq.animator.databinding.ActivityMainBinding
import com.zzq.util.ToastUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
        )

        binding.viewPropertyListener = View.OnClickListener {
            startActivity(Intent(this,ViewPropertyActivity::class.java))
        }
        binding.activityListener = View.OnClickListener {
            ToastUtil.showToast(this@MainActivity, "activityListener")
        }
        binding.dialogListener = View.OnClickListener {
            ToastUtil.showToast(this@MainActivity, "dialogListener")
        }
        binding.fragmentListener = View.OnClickListener {
            ToastUtil.showToast(this@MainActivity, "fragmentListener")
        }
        binding.dialogFragmentListener = View.OnClickListener {
            ToastUtil.showToast(this@MainActivity, "dialogFragmentListener")
        }
    }
}

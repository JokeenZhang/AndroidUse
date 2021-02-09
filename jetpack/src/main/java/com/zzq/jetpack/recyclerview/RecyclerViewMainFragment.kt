package com.zzq.jetpack.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zzq.common.utils.DensityUtil
import com.zzq.jetpack.R
import com.zzq.jetpack.recyclerview.adapter.MainAdapter
import com.zzq.recyclerview.decoration.VerticalProgressDecoration
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewMainFragment : Fragment(), View.OnClickListener {

    private val adapter = MainAdapter()
    private lateinit var rvMain: RecyclerView
    val random = Random()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recyclerview_main, container, false)

        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        tvTitle.text = "ItemDecoration"

        rvMain = view.findViewById(R.id.rv_main)
        rvMain.layoutManager = LinearLayoutManager(requireContext())
        rvMain.adapter = adapter
        val verticalProgressDecoration = VerticalProgressDecoration(requireContext())
        verticalProgressDecoration.bottomMargin = DensityUtil.dp2px(requireContext(), 10F)
        rvMain.addItemDecoration(verticalProgressDecoration)
        adapter.addNewData(createData())

        view.findViewById<Button>(R.id.btn_add).setOnClickListener(this)
        return view
    }

    private fun createData(): ArrayList<String> {
        val list = ArrayList<String>()
        repeat(30) {
            list.add("data: ${random.nextInt(50) + 10}")
        }
        return list
    }

    fun addData() {
        adapter.addData("data: ${random.nextInt(50) + 10}")
        rvMain.smoothScrollToPosition(adapter.itemCount)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add -> {
                addData()
            }
        }
    }
}
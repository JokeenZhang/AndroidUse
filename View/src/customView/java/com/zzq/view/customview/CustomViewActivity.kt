package com.zzq.view.customview

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.zzq.view.R
import com.zzq.view.customview.widget.VerticalTextView

class CustomViewActivity : AppCompatActivity() {

    private lateinit var vtView :VerticalTextView
    private lateinit var ivShow:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        vtView = findViewById(R.id.vt_view)
        ivShow = findViewById(R.id.iv_show)

    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(object :Runnable{
            override fun run() {
                val bitmap = view2Bitmap(vtView)
                ivShow.layoutParams.width = vtView.width
                ivShow.layoutParams.height = vtView.height
                ivShow.setImageBitmap(bitmap)
            }

        },1000)

    }

    /**
     * View to bitmap.
     *
     * @param view The com.zzq.view.
     * @return bitmap
     */
    fun view2Bitmap(view: View?): Bitmap? {
        if (view == null) return null
        val drawingCacheEnabled: Boolean = view.isDrawingCacheEnabled()
        val willNotCacheDrawing: Boolean = view.willNotCacheDrawing()
        view.setDrawingCacheEnabled(true)
        view.setWillNotCacheDrawing(false)
        var drawingCache: Bitmap = view.getDrawingCache()
        val bitmap: Bitmap
        if (null == drawingCache || drawingCache.isRecycled) {
            view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight())
            view.buildDrawingCache()
            drawingCache = view.getDrawingCache()
            if (null == drawingCache || drawingCache.isRecycled) {
                bitmap = Bitmap.createBitmap(
                    view.getMeasuredWidth(),
                    view.getMeasuredHeight(),
                    Bitmap.Config.RGB_565
                )
                val canvas = Canvas(bitmap)
                view.draw(canvas)
            } else {
                bitmap = Bitmap.createBitmap(drawingCache)
            }
        } else {
            bitmap = Bitmap.createBitmap(drawingCache)
        }
        view.setWillNotCacheDrawing(willNotCacheDrawing)
        view.setDrawingCacheEnabled(drawingCacheEnabled)
        return bitmap
    }
}
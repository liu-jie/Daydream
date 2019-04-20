package cn.eirture.daydream

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.OrientationEventListener
import android.widget.TextClock
import java.util.*
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {

    private lateinit var mOrientationEventListener: OrientationEventListener
    private lateinit var tvClock: TextClock

    private fun getOrientation(v: Int) = when (v) {
        in 0..30 -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        in 60..120 -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
//        in 150..210 -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        in 240..300 -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        in 330..360 -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        else -> null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initSensors()

    }

    private fun initViews() {
        tvClock = findViewById(R.id.tvClock)
        tvClock.textSize = 100f
    }

    private fun initSensors() {
        mOrientationEventListener = MyOrientationEventListener(this, Consumer {
            val newOrientation = getOrientation(it)
            if (newOrientation != null) {
                requestedOrientation = newOrientation
                tvClock.textSize =
                    if (newOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) 100f else 160f
            }
        })
    }

    override fun onStart() {
        super.onStart()
        mOrientationEventListener.enable()
    }

    override fun onStop() {
        super.onStop()
        mOrientationEventListener.disable()
    }

    private fun getDateStr(): String {
        val calender = Calendar.getInstance()
        return "${calender.get(Calendar.DAY_OF_MONTH)} ${WEEK_STRINGS[calender.get(Calendar.DAY_OF_WEEK) - 1]}"
    }

    companion object {
        private val WEEK_STRINGS = arrayListOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
    }
}

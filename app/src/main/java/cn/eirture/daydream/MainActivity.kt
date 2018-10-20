package cn.eirture.daydream

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getDateStr(): String {
        val calender = Calendar.getInstance()
        return "${calender.get(Calendar.DAY_OF_MONTH)} ${WEEK_STRINGS[calender.get(Calendar.DAY_OF_WEEK) - 1]}"
    }

    companion object {
        private val WEEK_STRINGS = arrayListOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
    }

}

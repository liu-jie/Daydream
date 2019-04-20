package cn.eirture.daydream

import android.content.Context
import android.util.Log
import android.view.OrientationEventListener
import java.util.function.Consumer

class MyOrientationEventListener(context: Context, private val listener: Consumer<Int>) :
    OrientationEventListener(context) {

    override fun onOrientationChanged(orientation: Int) {
        Log.d(TAG, orientation.toString())
        listener.accept(orientation)
    }

    companion object {
        val TAG: String = MyOrientationEventListener.javaClass.simpleName
    }
}
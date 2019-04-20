package cn.eirture.daydream

import android.service.dreams.DreamService

class RobotDaydream : DreamService() {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDreamingStarted() {
        super.onDreamingStarted()
        isFullscreen = true
        isScreenBright = false
        isInteractive = false
        setContentView(R.layout.activity_main)
    }

    override fun onDreamingStopped() {
        super.onDreamingStopped()
    }
}
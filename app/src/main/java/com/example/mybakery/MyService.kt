package com.example.mybakery

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {

    private lateinit var player: MediaPlayer
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, R.raw.recipe)

    player.setLooping(false)
    player.start()
    return START_STICKY
    }


    override fun onDestroy() {
    super.onDestroy()
    player.stop()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}
package com.tfg.meteodirecto.model

import android.content.Context
import android.media.MediaPlayer

class Musica(context: Context, rawResourceId: Int) {
    private val mediaPlayer: MediaPlayer = MediaPlayer.create(context, rawResourceId)

    init {
        mediaPlayer.isLooping = true
    }

    fun start() {
        mediaPlayer.start()
    }

    fun stop() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }
    fun pause() {
        mediaPlayer.pause()
    }


}
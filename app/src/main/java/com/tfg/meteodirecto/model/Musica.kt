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

    fun getIsSelected():Boolean{
        return mediaPlayer.isPlaying
    }
    fun pause() {
        mediaPlayer.pause()
    }


}
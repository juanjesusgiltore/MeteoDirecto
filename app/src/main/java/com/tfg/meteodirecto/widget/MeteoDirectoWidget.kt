package com.tfg.meteodirecto.widget

import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.text.Text
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.widget.elements.MeteoDirectoIcono

@Composable
fun MeteoDirectoWidget(){
    Box {
        Log .i("pasa","paso")
        MeteoDirectoIcono()
    }
}

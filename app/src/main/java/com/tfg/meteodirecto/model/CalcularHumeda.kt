package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.R

class CalcularHumeda {


    fun devolerImagen(humedadRelativa: Int):Int{

        var painter =0

        when{
            humedadRelativa  <=25 ->painter= R.drawable.humidity_low_24dp_fill0_wght400_grad0_opsz24
            humedadRelativa  <=75 -> painter=R.drawable.humidity_mid_24dp_fill0_wght400_grad0_opsz24
            humedadRelativa >75 -> painter=R.drawable.humidity_high_24dp_fill0_wght400_grad0_opsz24
        }
        return painter
    }
}
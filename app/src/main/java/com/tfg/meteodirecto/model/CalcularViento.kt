package com.tfg.meteodirecto.model

class CalcularViento {

    fun getDireccionViento(viento:String):String{
        var direccion=""

        when(viento){
            "NO"->direccion="Noroste"
            "NE"->direccion="Noreste"
            "N"->direccion="Norte"
            "SO"->direccion="Suroste"
            "SE"->direccion="Sureste"
            "S"->direccion="Sur"
            "O"->direccion="Oeste"
            "E"->direccion="Este"
            else -> direccion=viento
        }

        return direccion
    }
}
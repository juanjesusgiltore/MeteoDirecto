package com.tfg.meteodirecto.peticion.retrofit.datos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object InstanciaRetrofitDatos {
    private const val BASE_URL = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/"

    fun getRetrofitDatos(): InterfazRetrofitDatos {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(InterfazRetrofitDatos::class.java)
    }
}
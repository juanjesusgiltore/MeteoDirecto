package com.tfg.meteodirecto.peticion.retrofit.datos2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object InstanciaRetrofitDatos2 {
    private const val BASE_URL = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/horaria/"

    fun getRetrofitDatos2(): InterfazRetrofitDatos2 {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(InterfazRetrofitDatos2::class.java)
    }
}
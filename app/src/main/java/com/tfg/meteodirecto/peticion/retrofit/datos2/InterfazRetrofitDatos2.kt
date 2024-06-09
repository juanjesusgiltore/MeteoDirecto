package com.tfg.meteodirecto.peticion.retrofit.datos2

import com.tfg.meteodirecto.peticion.data.Datos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface InterfazRetrofitDatos2 {

    @GET("{codMun}")
    @Headers("accept: application/json")
    suspend fun getPeticion(
        @Header("api_key")apiKey:String,
        @Path("codMun") codMun:String):Response<Datos>
}
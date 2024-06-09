package com.tfg.meteodirecto.peticion.retrofit.tiempo2

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.TiempoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfazRetrofitTiempo2 {

    @GET("{endpoint}")
    suspend fun getTiempo(
        @Path("endpoint") endpoint:String):Response<List<TiempoHorarioItem>>
}
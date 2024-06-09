package com.tfg.meteodirecto.peticion.retrofit.tiempo

import com.tfg.meteodirecto.peticion.data.TiempoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface InterfazRetrofitTiempo {

    @GET("{endpoint}")
    suspend fun getTiempo(
        @Path("endpoint") endpoint:String):Response<List<TiempoItem>>
}
package com.tfg.meteodirecto.peticion.retrofit.tiempo

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanciaRetrofitTiempo {

    val gson = GsonBuilder().setLenient().create()

    /*private val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i("Inter",message) // Imprimir el mensaje de log
        }
    }).apply {
        level = HttpLoggingInterceptor.Level.BODY // Establecer el nivel de log para BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor) // Agregar el interceptor de registro
        .build()*/

    fun getRetrofitTiempo(BASE_URL:String): InterfazRetrofitTiempo {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            //.client(okHttpClient)
            .build().create(InterfazRetrofitTiempo::class.java)
    }
}
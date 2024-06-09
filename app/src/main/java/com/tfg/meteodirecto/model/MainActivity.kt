package com.tfg.meteodirecto.model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.DatabaseLocalidadesViewModel
import com.tfg.meteodirecto.navegation.NavgationApp
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel
import com.tfg.meteodirecto.ui.theme.MeteoDirectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeteoDirectoTheme {
                val databaseLocalidades= DatabaseLocalidadesViewModel(this)
                val databaseFavoritoViewModel= DatabaseFavoritoViewModel(this)
                val peticionDatosViewModel=PeticionDatosViewModel()
                val peticionTiempoViewModel=PeticionTiempoViewModel()
                val peticionDatos2ViewModel= PeticionDatos2ViewModel()
                val peticionTiempo2ViewModel= PeticionTiempo2ViewModel()

                NavgationApp(databaseLocalidades,databaseFavoritoViewModel,peticionDatosViewModel,
                    peticionTiempoViewModel,peticionDatos2ViewModel,peticionTiempo2ViewModel)
            }
        }
    }
}


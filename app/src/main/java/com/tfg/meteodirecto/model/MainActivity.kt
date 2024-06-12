package com.tfg.meteodirecto.model

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.DatabaseLocalidadesViewModel
import com.tfg.meteodirecto.navegation.NavgationApp
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel
import com.tfg.meteodirecto.ui.theme.MeteoDirectoTheme
import java.util.Locale

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private lateinit var musicPlayer: Musica
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var localizacion:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        musicPlayer = Musica(this, R.raw.musica)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Permiso de ubicación ya otorgado
            getLastLocation()
        } else {
            // Solicitar permiso de ubicación al usuario
            requestLocationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }




        setContent {
            MeteoDirectoTheme {
                Log.i("Pasa","1")
                val databaseLocalidades = DatabaseLocalidadesViewModel(this)
                databaseLocalidades.getlistlocalidades()
                if (localizacion.isNotEmpty()) {
                    databaseLocalidades.insertarGps(localizacion)
                }
                val databaseFavoritoViewModel = DatabaseFavoritoViewModel(this)
                val peticionDatosViewModel = PeticionDatosViewModel()
                val peticionTiempoViewModel = PeticionTiempoViewModel()
                val peticionDatos2ViewModel = PeticionDatos2ViewModel()
                val peticionTiempo2ViewModel = PeticionTiempo2ViewModel()
                NavgationApp(
                    databaseLocalidades,
                    databaseFavoritoViewModel,
                    peticionDatosViewModel,
                    peticionTiempoViewModel,
                    peticionDatos2ViewModel,
                    peticionTiempo2ViewModel,
                    musicPlayer
                )
            }
        }
    }
    private val requestLocationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permiso otorgado
            getLastLocation()
        } else {

        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getLastLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val latitude = location.latitude
                    val longitude = location.longitude

                    val geocoder = Geocoder(this, Locale.getDefault())
                    val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                    if (addresses?.isNotEmpty() == true) {
                        val address = addresses[0]
                         localizacion = address.locality
                        setContent {
                            MeteoDirectoTheme {
                                Log.i("Pasa","2")
                                val databaseLocalidades = DatabaseLocalidadesViewModel(this)
                                databaseLocalidades.getlistlocalidades()
                                databaseLocalidades.insertarGps(localizacion)
                                val databaseFavoritoViewModel = DatabaseFavoritoViewModel(this)
                                val peticionDatosViewModel = PeticionDatosViewModel()
                                val peticionTiempoViewModel = PeticionTiempoViewModel()
                                val peticionDatos2ViewModel = PeticionDatos2ViewModel()
                                val peticionTiempo2ViewModel = PeticionTiempo2ViewModel()
                                NavgationApp(
                                    databaseLocalidades,
                                    databaseFavoritoViewModel,
                                    peticionDatosViewModel,
                                    peticionTiempoViewModel,
                                    peticionDatos2ViewModel,
                                    peticionTiempo2ViewModel,
                                    musicPlayer
                                )
                            }
                        }
                    }
                }
            }
            .addOnFailureListener { e ->

            }
    }
}


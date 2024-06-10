package com.tfg.meteodirecto.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.screen.MenuBar
import com.tfg.meteodirecto.screen.SearchBar
import com.tfg.meteodirecto.database.DatabaseLocalidadesViewModel
import com.tfg.meteodirecto.model.Musica
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel

@Composable
fun NavgationApp(
    databaseLocalidades: DatabaseLocalidadesViewModel,
    databaseFavoritoViewModel: DatabaseFavoritoViewModel,
    peticionDatosViewModel: PeticionDatosViewModel,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    peticionDatos2ViewModel: PeticionDatos2ViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
    musicPlayer: Musica,
){
    val navController=rememberNavController()

    NavHost(navController = navController, startDestination =SelectNavegation.MainScreen.route ) {
        composable(route=SelectNavegation.MainScreen.route){
            MenuBar(navController = navController,databaseFavoritoViewModel,
                peticionDatosViewModel,peticionTiempoViewModel,
                peticionDatos2ViewModel,peticionTiempo2ViewModel,musicPlayer)
        }
        composable(route=SelectNavegation.SearchBar.route){
            SearchBar(navController,databaseLocalidades,databaseFavoritoViewModel,musicPlayer)
        }
    }
}
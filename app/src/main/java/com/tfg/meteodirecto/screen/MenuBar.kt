package com.tfg.meteodirecto.screen

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.elements.ListaFavoritos
import com.tfg.meteodirecto.elements.MainScreen
import com.tfg.meteodirecto.elements.TopBar
import com.tfg.meteodirecto.navegation.SelectNavegation
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel
import kotlinx.coroutines.launch


@Composable
fun MenuBar(
    navController: NavController,
    databaseFavoritoViewModel: DatabaseFavoritoViewModel,
    peticionDatosViewModel: PeticionDatosViewModel,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    peticionDatos2ViewModel: PeticionDatos2ViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel
) {
    databaseFavoritoViewModel.getlistfavoritos()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val activity = LocalContext.current as Activity
    val favoritos by databaseFavoritoViewModel.todasLosFavoritos.observeAsState()
    val isSelected by databaseFavoritoViewModel.isSelected.observeAsState()


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White,

                ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    ) {
                      Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                          contentDescription ="back" )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .background(Color.White)
                        .clickable {
                            navController.navigate(route = SelectNavegation.SearchBar.route)
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "IconMenu",
                        )

                        Text(
                            text = stringResource(id = R.string.añadir),
                            modifier = Modifier

                        )
                    }
                }
                }
                ListaFavoritos(databaseFavoritoViewModel)
            }
        },
        )
    {
        Scaffold(
            topBar = { TopBar(drawerState, scope) },
        ) { innerPadding ->
            favoritos?.forEach {favorito->
                if(favorito.isSelected==1 && isSelected?.get(favorito)==true ){
                    Log.i("fav",favorito.toString())
                MainScreen(innerPadding,favorito,peticionDatosViewModel,peticionTiempoViewModel,
                    peticionDatos2ViewModel,peticionTiempo2ViewModel)
            }else{
                    CircularProgressIndicator()

                }
            }

        }


    }
    BackHandler {
        if (drawerState.isOpen){
            scope.launch {
                drawerState.close()
            }
        }else{
            activity.finish()
        }
    }
}





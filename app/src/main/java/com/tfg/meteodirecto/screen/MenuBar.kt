package com.tfg.meteodirecto.screen

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.DatabaseLocalidadesViewModel
import com.tfg.meteodirecto.elements.ListaFavoritos
import com.tfg.meteodirecto.elements.MainScreen
import com.tfg.meteodirecto.elements.TopBar
import com.tfg.meteodirecto.model.Musica
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
    databaseLocalidadesViewModel: DatabaseLocalidadesViewModel,
    peticionDatosViewModel: PeticionDatosViewModel,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    peticionDatos2ViewModel: PeticionDatos2ViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
    musicPlayer: Musica,
    ) {
    databaseFavoritoViewModel.getlistfavoritos()

    val nombregps by databaseLocalidadesViewModel.localgps.observeAsState()
    val localidadgps by databaseLocalidadesViewModel.localidadgps.observeAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val activity = LocalContext.current as Activity
    val favoritos by databaseFavoritoViewModel.todasLosFavoritos.observeAsState()
    val isSelected by databaseFavoritoViewModel.isSelected.observeAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    var musica by rememberSaveable { mutableStateOf(true) }


    LaunchedEffect(nombregps) {
        nombregps?.let {
            databaseLocalidadesViewModel.getLocalidad(it)
        }
    }
    LaunchedEffect(localidadgps) {
        localidadgps?.let {
            Log.i("menu",localidadgps.toString())
                databaseFavoritoViewModel.insertarLocalidadGPS(it)
        }
    }


    if(musica){
        musicPlayer.start()
    }

if(musica) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> musicPlayer.pause()
                Lifecycle.Event.ON_RESUME -> musicPlayer.start()
                else -> Unit
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor =MaterialTheme.colorScheme.surfaceVariant,
                drawerContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f) )
                        IconToggleButton(
                            checked =musica ,
                            onCheckedChange ={isCheck->
                                musica=isCheck
                                if (isCheck) {
                                    musicPlayer.start()
                                } else {
                                    musicPlayer.pause()

                                }
                            }

                        ) {
                            if (musica) {
                                Icon(
                                    painter = painterResource(id = R.drawable.volume_up_24dp_fill0_wght400_grad0_opsz24),
                                    contentDescription = "Pause"
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = R.drawable.volume_off_24dp_fill0_wght400_grad0_opsz24),
                                    contentDescription = "Play"
                                )
                            }

                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
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
                ListaFavoritos(databaseFavoritoViewModel,databaseLocalidadesViewModel)
            }
        },
        )
    {
        Scaffold(
            topBar = { TopBar(drawerState, scope) },
        ) { innerPadding ->
                favoritos?.forEach { favorito ->
                    Log.i("fav1", favorito.toString())
                    if (favorito.isSelected == 1 && isSelected?.get(favorito) == true) {
                        MainScreen(
                            innerPadding, favorito, peticionDatosViewModel, peticionTiempoViewModel,
                            peticionDatos2ViewModel, peticionTiempo2ViewModel
                        )
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





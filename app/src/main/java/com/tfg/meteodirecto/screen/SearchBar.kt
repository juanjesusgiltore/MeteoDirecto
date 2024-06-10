package com.tfg.meteodirecto.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.DatabaseLocalidadesViewModel
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.database.entities.Localidades
import com.tfg.meteodirecto.elements.AlertaFallo
import com.tfg.meteodirecto.model.Musica
import com.tfg.meteodirecto.navegation.SelectNavegation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    navController: NavController, databaseLocalidades: DatabaseLocalidadesViewModel,
    databaseFavoritoViewModel: DatabaseFavoritoViewModel,
    musicPlayer: Musica,
){
    var query by remember { mutableStateOf("") }
    var isActive by remember { mutableStateOf(true) }
    val localidades:List<Localidades> by databaseLocalidades.todasLasLocalidades.observeAsState(initial = emptyList())
    val flag by databaseLocalidades.flag.observeAsState()
    val flag2 by databaseFavoritoViewModel.flag.observeAsState()

    var navigateToMainScreen by remember { mutableStateOf(false) }

    DisposableEffect(key1 = musicPlayer) {
        onDispose {
            musicPlayer.pause()
        }
    }

if(flag==true) {
    SearchBar(
        leadingIcon = {
            IconButton(
                onClick = { navController.popBackStack() }
            )
            {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        query = query,
        onQueryChange = { query = it },
        onSearch = { isActive = false },
        active = isActive,
        onActiveChange = {}
    ) {
        if(query.length>=3) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)

            ) {
                items(localidades.filter { it.NOMBRE.contains(query, true) }) { localidad ->
                    val favorito= Favoritos(
                        CODAUTO =localidad.CODAUTO,
                        CPRO =localidad.CPRO,
                        CMUN =localidad.CMUN ,
                        DC= localidad.DC,
                        NOMBRE = localidad.NOMBRE,
                        isSelected = 1,
                    )
                    Row(
                        modifier= Modifier
                            .fillMaxWidth()
                            .clickable {
                                navigateToMainScreen=true
                                databaseFavoritoViewModel.insertarFavorito(favorito)
                            }
                    ) {
                        Text(text = localidad.NOMBRE)
                    }
                }
            }
        }else{
            Text(text = stringResource(id = R.string.caracter))
        }
    }
}else{
    Box(modifier =Modifier.fillMaxSize(), contentAlignment = Alignment.Center ){
    CircularProgressIndicator()
    }
        databaseLocalidades.getlistlocalidades()
}
    if(flag2==false && navigateToMainScreen){
        AlertaFallo(databaseFavoritoViewModel = databaseFavoritoViewModel){
            navigateToMainScreen=false
        }
    }else if(flag2==true && navigateToMainScreen){
        navController.navigate(SelectNavegation.MainScreen.route)
    }

    BackHandler {
        navController.popBackStack()
    }

}

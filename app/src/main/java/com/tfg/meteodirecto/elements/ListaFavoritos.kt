package com.tfg.meteodirecto.elements

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.DatabaseLocalidadesViewModel


@SuppressLint("SuspiciousIndentation")
@Composable
fun ListaFavoritos(
    databaseFavoritoViewModel: DatabaseFavoritoViewModel,
    databaseLocalidadesViewModel: DatabaseLocalidadesViewModel

){
    val favoritos by databaseFavoritoViewModel.todasLosFavoritos.observeAsState(initial = emptyList())


    Log.i("lol",favoritos.toString())
        LazyColumn {
            items(favoritos) { item ->
                Favorito(
                    favorito = item,
                    databaseFavoritoViewModel = databaseFavoritoViewModel,
                    databaseLocalidadesViewModel = databaseLocalidadesViewModel,
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
}




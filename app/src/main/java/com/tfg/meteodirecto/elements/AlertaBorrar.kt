package com.tfg.meteodirecto.elements

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.entities.Favoritos

@Composable
fun AlertaBorrar(databaseFavoritoViewModel: DatabaseFavoritoViewModel, favoritos: Favoritos, OnClose:() -> Unit){
    AlertDialog(
        text = {
            Text(text = stringResource(id = R.string.asegurar) )

        },
        onDismissRequest = { 
            OnClose()
        },
        confirmButton = {
            Button(onClick = {
                databaseFavoritoViewModel.eliminarFavorito(favoritos)
                OnClose()
            }) {
                Text(text = stringResource(id = R.string.borrar))
            }
        },
        dismissButton = {
            Button(onClick = {
                OnClose()
            }) {
                Text(text = stringResource(id = R.string.cancelar))
            }
        }
    
    )
}
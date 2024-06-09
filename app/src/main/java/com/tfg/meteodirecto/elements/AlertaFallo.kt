package com.tfg.meteodirecto.elements

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel


@Composable
fun AlertaFallo(databaseFavoritoViewModel: DatabaseFavoritoViewModel,Onclick:() -> Unit){
    AlertDialog(
        text = {
            Text(text = stringResource(id = R.string.fallo) )
        },
        onDismissRequest = {
            databaseFavoritoViewModel.setFavoritos()
            Onclick()
        },
        confirmButton = {},
        dismissButton = {
            Button(onClick = {
                databaseFavoritoViewModel.setFavoritos()
                Onclick()
            }) {
                Text(text = stringResource(id = R.string.btfallo))
            }
        }

    )
}
package com.tfg.meteodirecto.elements

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.database.DatabaseFavoritoViewModel
import com.tfg.meteodirecto.database.entities.Favoritos


@Composable
fun Favorito(
    favorito: Favoritos,
    databaseFavoritoViewModel: DatabaseFavoritoViewModel,
    ){

    var alerta by remember { mutableStateOf(false) }
    val isSelected by databaseFavoritoViewModel.isSelected.observeAsState()




    Box(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize()
        .border(
            if (isSelected?.get(favorito) == true) {
                BorderStroke(1.dp, Color.Black)
            } else {
                BorderStroke(0.dp, Color.White)
            },
            ShapeDefaults.Small
        )
    ){
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier=Modifier
                    .clickable {
                        databaseFavoritoViewModel.cambioSelecionado(favorito)
                    }

            ) {
                Text(text = favorito.NOMBRE)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        alerta=true
                    }) {
                    Icon(imageVector =Icons.Default.Delete ,
                        contentDescription ="Eliminar" )
                }
            }

        }
    }
    if (alerta){
        AlertaBorrar(databaseFavoritoViewModel,favorito){
            alerta=false
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FavoritoPreview(){
    val favoritos=Favoritos(
        CODAUTO="111",
        CPRO="222",
        CMUN="333",
        DC="444",
        NOMBRE="Málaga",
        isSelected =1
    )
    var abrircerrar by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize()
        .border(
            if (favoritos.isSelected == 1) {
                BorderStroke(1.dp, Color.Black)
            } else {
                BorderStroke(0.dp, Color.White)
            },
            ShapeDefaults.Small
        )
    ){
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = favoritos.NOMBRE)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        abrircerrar=!abrircerrar
                    }) {
                    if (!abrircerrar) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "FlechaAbajo"
                        )
                    }else{
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "FlechaArriba"
                        )
                    }
                }
                IconButton(
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector =Icons.Default.Delete ,
                        contentDescription ="Eliminar" )
                }
            }
            if(abrircerrar){
                Column {
                    Row {
                        Text(text = favoritos.CODAUTO)
                    }
                    Row {
                        Text(text = favoritos.CMUN)
                    }
                    Row {
                        Text(text = favoritos.CPRO)
                    }
                    Row {
                        Text(text = favoritos.DC)
                    }
                }
            }
        }
    }
}
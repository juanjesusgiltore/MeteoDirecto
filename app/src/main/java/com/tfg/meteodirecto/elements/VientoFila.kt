package com.tfg.meteodirecto.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.VientoAndRachaMax

@Composable
fun VientoFila(viento: VientoAndRachaMax, peticionTiempoViewModel: PeticionTiempo2ViewModel) {
    Column {
        Text(text = viento.periodo+":00")
        Icon(painter = painterResource(id = R.drawable.air_24dp_fill0_wght400_grad0_opsz24), contentDescription ="viento" )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = viento.velocidad[0]+"Km/h")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = peticionTiempoViewModel.getViento(viento.direccion[0]),)
    }
}
package com.tfg.meteodirecto.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbNieve

@Composable
fun ElementoNieve(probab: ProbNieve, peticionTiempo2ViewModel: PeticionTiempo2ViewModel) {
    val hora=peticionTiempo2ViewModel.getHoraParseada(probab.periodo)
    Column {
        Icon(painter = painterResource(id = R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24), contentDescription ="tormenta" )
        Text(text =probab.value+"%")
        Text(text = hora)
    }

}
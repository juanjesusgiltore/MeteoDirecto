package com.tfg.meteodirecto.elements

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.model.CalcularDia
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel
import com.tfg.meteodirecto.peticion.data.dataTiempo.Dia

@Composable
fun FilaTabla(
    dia: Dia,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
    ){

    val diaFecha= peticionTiempo2ViewModel.getDias(dia.fecha)
    var isOpen by remember{ mutableStateOf(false) }
    val imagenHumedad=peticionTiempoViewModel.getHumedad(dia)
    val estadocielo=peticionTiempoViewModel.getEstadoCielo(dia)


    Box(modifier = Modifier
        .animateContentSize()
        .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        isOpen = !isOpen
                    }
            ) {
                Icon(
                    painter = painterResource(id =estadocielo ),
                    contentDescription = "estadocielo"
                )
                Text(text = diaFecha)
                Icon(
                    painter = painterResource(id = R.drawable.water_drop_24dp_fill0_wght400_grad0_opsz24),
                    contentDescription = "gota"
                )
                Text(text = dia.probPrecipitacion[0].value.toString() + "%")
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.device_thermostat_24dp_fill0_wght400_grad0_opsz24),
                    contentDescription = "termometro"
                )
                Text(text = dia.temperatura.maxima.toString() + "º")
                Text(text = dia.temperatura.minima.toString() + "º")
            }
            if(isOpen){
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(text = stringResource(id = R.string.humedad))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(painter = painterResource(id = imagenHumedad), contentDescription ="humedad" )
                    Text(text = dia.humedadRelativa.maxima.toString()+"%")
                    Text(text = dia.humedadRelativa.minima.toString()+"%")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(text = stringResource(id = R.string.senstermica))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(painterResource(id = R.drawable.device_thermostat_24dp_fill0_wght400_grad0_opsz24), contentDescription ="viento")
                    Text(text = dia.sensTermica.maxima.toString()+"º")
                    Text(text = dia.sensTermica.minima.toString()+"º")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(text = stringResource(id = R.string.viento))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(painterResource(id = R.drawable.air_24dp_fill0_wght400_grad0_opsz24), contentDescription ="viento")
                    Text(text =peticionTiempo2ViewModel.getViento(dia.viento[0].direccion))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = dia.viento[0].velocidad.toString()+"Km/h")
                }

            }
        }
    }
}
package com.tfg.meteodirecto.elements

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Precipitacion
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.SensTermica2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Temperatura2

@Composable
fun ElementoFila(
    temperatura2: Temperatura2,
    humedadRelativa2: HumedadRelativa2,
    sensTermica2: SensTermica2,
    probPrecipitacion2: Precipitacion,
    estadoCielo2: EstadoCielo2,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel
) {
    val estado = peticionTiempo2ViewModel.getEstadoIcono(estadoCielo2.descripcion)
    val humeda = peticionTiempo2ViewModel.getIconoHumedad(humedadRelativa2.value.toInt())
    var isOpen by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .wrapContentSize()
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    isOpen = !isOpen
                }
        ) {
            if (isOpen) {
                Column(

                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Icon(painter = painterResource(id =R.drawable.device_thermostat_24dp_fill0_wght400_grad0_opsz24 ), contentDescription = "senstermica")
                    Text(text = sensTermica2.value + "º")
                }
            }
                Column(

                ) {
                    Text(text = temperatura2.periodo + ":00")
                    Icon(painter = painterResource(id = estado), contentDescription = "Icono")
                    Text(text = temperatura2.value + "º")
                    Text(text = probPrecipitacion2.value + "%")
                    Icon(
                        painter = painterResource(id = R.drawable.water_drop_24dp_fill0_wght400_grad0_opsz24),
                        contentDescription = "gota"
                    )
                }
                if (isOpen) {
                    Column(

                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Icon(painter = painterResource(id = humeda), contentDescription = "humedad")
                        Text(text = humedadRelativa2.value + "%")
                    }
                }
            }
        }
    }
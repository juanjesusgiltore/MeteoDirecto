package com.tfg.meteodirecto.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel


@Composable
fun FilaProbabilidades(peticionTiempo2ViewModel: PeticionTiempo2ViewModel){
    Box(modifier = Modifier
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = RoundedCornerShape(16.dp)
        )
        .padding(8.dp)

    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
        ){
            Text(text = stringResource(id = R.string.tormenta))
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(16.dp))
            ProbabilidadTormenta(peticionTiempo2ViewModel)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = stringResource(id = R.string.nieve))
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(16.dp))
            ProbabilidadNieve(peticionTiempo2ViewModel)

        }
    }
}
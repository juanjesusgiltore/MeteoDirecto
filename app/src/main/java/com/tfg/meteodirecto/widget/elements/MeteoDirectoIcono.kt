package com.tfg.meteodirecto.widget.elements



import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.width
import androidx.glance.text.Text
import com.tfg.meteodirecto.R

@Composable
fun MeteoDirectoIcono(){

    val max="20"
    val min="25"
    val image= ImageProvider(resId = R.drawable.sunny_24dp_fill0_wght400_grad0_opsz24)
    Box(){
        Column {
            Image(provider =image , contentDescription ="icono" )
            Row {
                Text(text =min+"º" )
                Spacer(GlanceModifier.width(10.dp))
                Text(text =max+"º" )
            }
        }
    }
}

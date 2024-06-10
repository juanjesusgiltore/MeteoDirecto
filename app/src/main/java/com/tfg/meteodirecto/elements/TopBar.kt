package com.tfg.meteodirecto.elements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.tfg.meteodirecto.ui.theme.MeteoDirectoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(drawerState: DrawerState,scope:CoroutineScope){

        TopAppBar(
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(imageVector =Icons.Default.Menu ,
                        contentDescription ="back" )
                }
            },
            title = {},
        )

}


@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    MeteoDirectoTheme {
        TopBar(rememberDrawerState(initialValue = DrawerValue.Open),
            rememberCoroutineScope())
    }
}

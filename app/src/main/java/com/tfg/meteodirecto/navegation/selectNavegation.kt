package com.tfg.meteodirecto.navegation

sealed class SelectNavegation(val route:String) {

    object SearchBar:SelectNavegation("SearchBar")

    object MainScreen:SelectNavegation("MainScreen")

}
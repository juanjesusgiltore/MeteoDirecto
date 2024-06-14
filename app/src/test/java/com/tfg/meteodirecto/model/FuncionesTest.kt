package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Dia2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Origen2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Precipitacion
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Prediccion2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbPrecipitacion2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbTormenta
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.SensTermica2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Temperatura2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.VientoAndRachaMax

class FuncionesTest {

    fun crearListaDeTiempoHorarioItem(): List<TiempoHorarioItem> {

        return listOf(
            TiempoHorarioItem(
                elaborado = "2024-06-14T00:00:00Z",
                id = "1",
                nombre = "Madrid",
                origen = Origen2(
                    copyright = "AEMET",
                    enlace = "http://www.aemet.es",
                    language = "es",
                    notaLegal = "© AEMET",
                    productor = "AEMET",
                    web = "http://www.aemet.es"
                ),
                prediccion = Prediccion2(
                    dia = listOf(
                        Dia2(
                            estadoCielo = listOf(
                                EstadoCielo2(
                                    descripcion = "Despejado",
                                    periodo = "00-06",
                                    value = "clear"
                                )
                            ),
                            fecha = "2024-06-14",
                            humedadRelativa = listOf(
                                HumedadRelativa2(
                                    periodo = "14",
                                    value = "50"
                                )
                            ),
                            nieve = listOf(),
                            ocaso = "22:00",
                            orto = "06:00",
                            precipitacion = listOf(
                                Precipitacion(
                                    periodo = "12",
                                    value = "0.5"
                                )
                            ),
                            probNieve = listOf(),
                            probPrecipitacion = listOf(
                                ProbPrecipitacion2(
                                    periodo = "00-06",
                                    value = "0"
                                )
                            ),
                            probTormenta = listOf(
                                ProbTormenta(
                                    periodo = "00-06",
                                    value = "0"
                                )
                            ),
                            sensTermica = listOf(
                                SensTermica2(
                                    periodo = "12",
                                    value = "15"
                                )
                            ),
                            temperatura = listOf(
                                Temperatura2(
                                    periodo = "12",
                                    value = "30"
                                )
                            ),
                            vientoAndRachaMax = listOf(
                                VientoAndRachaMax(
                                    direccion = listOf("N"),
                                    periodo = "12",
                                    value = "10",
                                    velocidad = listOf("10")
                                )
                            )
                        ),
                        Dia2(
                            estadoCielo = listOf(
                                EstadoCielo2(
                                    descripcion = "Nublado",
                                    periodo = "11",
                                    value = "cloudy"
                                )
                            ),
                            fecha = "2024-06-15",
                            humedadRelativa = listOf(
                                HumedadRelativa2(
                                    periodo = "14",
                                    value = "60"
                                )
                            ),
                            nieve = listOf(),
                            ocaso = "22:01",
                            orto = "06:01",
                            precipitacion = listOf(
                                Precipitacion(
                                    periodo = "06",
                                    value = "0.5"
                                )
                            ),
                            probNieve = listOf(),
                            probPrecipitacion = listOf(
                                ProbPrecipitacion2(
                                    periodo = "06-12",
                                    value = "20"
                                )
                            ),
                            probTormenta = listOf(
                                ProbTormenta(
                                    periodo = "06-12",
                                    value = "10"
                                )
                            ),
                            sensTermica = listOf(
                                SensTermica2(
                                    periodo = "12",
                                    value = "15"
                                )
                            ),
                            temperatura = listOf(
                                Temperatura2(
                                    periodo = "12",
                                    value = "30"
                                )
                            ),
                            vientoAndRachaMax = listOf(
                                VientoAndRachaMax(
                                    direccion = listOf("E"),
                                    periodo = "06",
                                    value = "15",
                                    velocidad = listOf("15")
                                )
                            )
                        )
                    )
                ),
                provincia = "Madrid",
                version = "1.0"
            )
        )
    }

    fun crearTiempoHorarioItemDePrueba(): TiempoHorarioItem {
        return TiempoHorarioItem(
            elaborado = "2024-06-14T00:00:00Z",
            id = "1",
            nombre = "Madrid",
            origen = Origen2(
                copyright = "AEMET",
                enlace = "http://www.aemet.es",
                language = "es",
                notaLegal = "© AEMET",
                productor = "AEMET",
                web = "http://www.aemet.es"
            ),
            prediccion = Prediccion2(
                dia = listOf(
                    Dia2(
                        estadoCielo = listOf(
                            EstadoCielo2(
                                descripcion = "Despejado",
                                periodo = "00-06",
                                value = "clear"
                            )
                        ),
                        fecha = "2024-06-14",
                        humedadRelativa = listOf(
                            HumedadRelativa2(
                                periodo = "12",
                                value = "50"
                            )
                        ),
                        nieve = listOf(),
                        ocaso = "22:00",
                        orto = "06:00",
                        precipitacion = listOf(
                            Precipitacion(
                                periodo = "12",
                                value = "0.2"
                            )
                        ),
                        probNieve = listOf(),
                        probPrecipitacion = listOf(
                            ProbPrecipitacion2(
                                periodo = "00-06",
                                value = "0"
                            )
                        ),
                        probTormenta = listOf(
                            ProbTormenta(
                                periodo = "00-06",
                                value = "0"
                            )
                        ),
                        sensTermica = listOf(
                            SensTermica2(
                                periodo = "00-06",
                                value = "15"
                            )
                        ),
                        temperatura = listOf(
                            Temperatura2(
                                periodo = "00-06",
                                value = "15"
                            )
                        ),
                        vientoAndRachaMax = listOf(
                            VientoAndRachaMax(
                                direccion = listOf("N"),
                                periodo = "00-06",
                                value = "10",
                                velocidad = listOf("10")
                            )
                        )
                    ),
                    Dia2(
                        estadoCielo = listOf(
                            EstadoCielo2(
                                descripcion = "Nublado",
                                periodo = "06-12",
                                value = "cloudy"
                            )
                        ),
                        fecha = "2024-06-15",
                        humedadRelativa = listOf(
                            HumedadRelativa2(
                                periodo = "12",
                                value = "60"
                            )
                        ),
                        nieve = listOf(),
                        ocaso = "22:01",
                        orto = "06:01",
                        precipitacion = listOf(
                            Precipitacion(
                                periodo = "12",
                                value = "0.5"
                            )
                        ),
                        probNieve = listOf(),
                        probPrecipitacion = listOf(
                            ProbPrecipitacion2(
                                periodo = "06-12",
                                value = "20"
                            )
                        ),
                        probTormenta = listOf(
                            ProbTormenta(
                                periodo = "06-12",
                                value = "10"
                            )
                        ),
                        sensTermica = listOf(
                            SensTermica2(
                                periodo = "06-12",
                                value = "18"
                            )
                        ),
                        temperatura = listOf(
                            Temperatura2(
                                periodo = "06-12",
                                value = "18"
                            )
                        ),
                        vientoAndRachaMax = listOf(
                            VientoAndRachaMax(
                                direccion = listOf("E"),
                                periodo = "06-12",
                                value = "15",
                                velocidad = listOf("15")
                            )
                        )
                    )
                )
            ),
            provincia = "Madrid",
            version = "1.0"
        )
    }


}
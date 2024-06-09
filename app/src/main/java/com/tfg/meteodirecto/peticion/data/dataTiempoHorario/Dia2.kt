package com.tfg.meteodirecto.peticion.data.dataTiempoHorario

data class Dia2(
    val estadoCielo: List<EstadoCielo2>,
    val fecha: String,
    val humedadRelativa: List<HumedadRelativa2>,
    val nieve: List<Nieve>,
    val ocaso: String,
    val orto: String,
    val precipitacion: List<Precipitacion>,
    val probNieve: List<ProbNieve>,
    val probPrecipitacion: List<ProbPrecipitacion2>,
    val probTormenta: List<ProbTormenta>,
    val sensTermica: List<SensTermica2>,
    val temperatura: List<Temperatura2>,
    val vientoAndRachaMax: List<VientoAndRachaMax>
)
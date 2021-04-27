package main.entity

import java.time.LocalDate

class Reserva(
    var tipoCliente: String,
    var dates: List<LocalDate>
){
    fun isFidelidade(): Boolean = this.tipoCliente == "fidelidade"
}
package main

import main.entity.Hotel
import main.entity.Reserva
import main.service.ReservaService
import java.time.LocalDate

fun main() {

    val reserva = Reserva(
        tipoCliente = "fidelidade",
        dates = listOf(
            LocalDate.now(),
            LocalDate.now().plusDays(1),
            LocalDate.now().plusDays(2),
            LocalDate.now().plusDays(3),
        )
    )
    val bestHotel = ReservaService().findBestHotel(reserva)
    println(bestHotel.name)
}
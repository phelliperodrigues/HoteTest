package main

import java.time.LocalDate

fun main() {
    val hotel3 = Hotel(
        name = "3",
        classificacao = 3,
        valorDiariaFiliado = 150.0,
        valorDiariaRegular = 160.0,
        valorFDSFilido = 20.0,
        valorFDSRegular = 80.0
    )

    val hotel1 = Hotel(
        name = "1",
        classificacao = 10,
        valorDiariaFiliado = 110.0,
        valorDiariaRegular = 110.0,
        valorFDSFilido = 40.0,
        valorFDSRegular = 60.0
    )

    val hotel2 = Hotel(
        name = "2",
        classificacao = 4,
        valorDiariaFiliado = 110.0,
        valorDiariaRegular = 120.0,
        valorFDSFilido = 40.0,
        valorFDSRegular = 50.0
    )


    val listHotels = listOf(hotel1, hotel2,hotel3)



    val reserva = Reserva(
        tipoCliente = "fidelidade",
        dates = listOf(
            LocalDate.now(),
            LocalDate.now().plusDays(1),
            LocalDate.now().plusDays(2),
            LocalDate.now().plusDays(3),
        )
    )
    val bestHotel = reserva.getBestHotle(listHotels)
    println(bestHotel.name)
}
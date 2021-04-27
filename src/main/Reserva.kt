package main

import java.time.LocalDate

class Reserva(
    var tipoCliente: String,
    var dates: List<LocalDate>
){
    fun isFidelidade(): Boolean = this.tipoCliente == "fidelidade"

    fun getBestHotle(hotels: List<Hotel>): Hotel {
        var bestValue: Double? = null
        var bestHotel: Hotel? = null
        hotels.forEach {
            hotel ->
            val total = hotel.calcule(this)
            if (bestValue != null) {
                if (bestValue!! > total){
                    bestValue = total
                    bestHotel = hotel
                } else if (bestValue == total){
                    bestHotel = if (bestHotel!!.classificacao > hotel.classificacao) bestHotel else hotel
                }
            } else {
                bestValue = total
                bestHotel = hotel
            }


        }
        return bestHotel!!
    }
}
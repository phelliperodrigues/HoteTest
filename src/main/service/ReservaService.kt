package main.service

import main.entity.Hotel
import main.entity.Reserva

class ReservaService {

    fun findBestHotel(reserva: Reserva): Hotel {
        val hotels = Hotel.buildHotels()
        var bestValue: Double? = null
        var bestHotel: Hotel? = null
        hotels.forEach {
                hotel ->
            val total = hotel.calcule(reserva)
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
package main.entity

import java.time.LocalDate

open class Hotel(
    var name: String,
    var classificacao: Int,
    var valorDiariaRegular: Double,
    var valorDiariaFiliado: Double,
    var valorFDSRegular: Double,
    var valorFDSFilido: Double
) {
    fun calcule(reserva: Reserva): Double{
        var total = 0.0
        if (reserva.isFidelidade()){
            total += calculeDiadeSemana(this.valorDiariaFiliado,  reserva.dates)
            total += calculeFDS(this.valorFDSFilido, reserva.dates)
        }else {
            total += calculeDiadeSemana(this.valorDiariaRegular,reserva.dates)
            total += calculeFDS(this.valorFDSRegular, reserva.dates)
        }
        return total
    }

    private fun calculeDiadeSemana(valor: Double, dates: List<LocalDate>): Double{
        var total = 0.0
        dates.stream().filter {
            data ->
            data.dayOfWeek.value in 1..5
        }.forEach {
            total += valor
        }

        return total
    }

    private fun calculeFDS(valor: Double, dates: List<LocalDate>): Double {
        var total = 0.0
        dates.stream().filter {
                data ->
            data.dayOfWeek.value == 0 || data.dayOfWeek.value == 6
        }.forEach {
            total += valor
        }
        return total
    }

    companion object {
        fun buildHotels(): List<Hotel> {
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

            return  listOf(hotel1, hotel2,hotel3)
        }
    }
}

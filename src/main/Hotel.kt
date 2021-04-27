package main

import java.time.LocalDate

class Hotel(
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
}

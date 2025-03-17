package store.model

import java.time.LocalDate

class Promotion(val promotion: String, val buy: Int, val get: Int, val startDate: LocalDate, val endDate: LocalDate) {
    companion object {
    fun allocatePromotion(promotion: String, buy: String, get: String, startDate: String, endDate: String): Promotion {
        val buy = buy.toInt()
        val get = get.toInt()
        val startDate = LocalDate.parse(startDate)
        val endDate = LocalDate.parse(endDate)
        return Promotion(promotion, buy, get, startDate, endDate)
        }
    }

    fun checkDate():Boolean {
        val nowDate = LocalDate.now()
        return nowDate.isAfter(startDate) && nowDate.isBefore(endDate)
    }
}
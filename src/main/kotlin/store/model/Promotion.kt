package store.model

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDate

class Promotion(val promotion: String, val buy: Int, val get: Int, val startDate: LocalDate, val endDate: LocalDate) {

    companion object {
        val path: Path = Paths.get("src/main/resources/promotions.md")

        private fun getPromotionList(): List<String> {
        val promotionList = Files.lines(path, Charsets.UTF_8).toList()
        return promotionList
    }

    fun splitPromotionList(): List<Promotion> {
        val promotionList = getPromotionList().map { it.split(",") }
        val promotionSplitList = promotionList.map { allocatePromotion(it[0], it[1], it[2], it[3], it[4]) }
        return promotionSplitList
    }

    fun allocatePromotion(promotion: String, buy: String, get: String, startDate: String, endDate: String): Promotion {
        val buy = buy.toInt()
        val get = get.toInt()
        val startDate = LocalDate.parse(startDate)
        val endDate = LocalDate.parse(endDate)
        return Promotion(promotion, buy, get, startDate, endDate)
        }
    }
}

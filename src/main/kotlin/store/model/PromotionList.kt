package store.model

import store.model.Promotion.Companion.allocatePromotion
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDate

class PromotionList {
    val path: Path = Paths.get("src/main/resources/promotions.md")

    private fun splitPromotionList(): List<String> {
        val promotionSplitList = Files.lines(path, Charsets.UTF_8).toList()
        return promotionSplitList
    }

    fun getPromotionList(): List<Promotion> {
        val promotionSplitList = splitPromotionList().map { it.split(",") }
        val promotionList = promotionSplitList.subList(1, promotionSplitList.size).map { allocatePromotion(it[0], it[1], it[2], it[3], it[4]) }
        return promotionList + listOf(Promotion("null", 0, 0, LocalDate.now(), LocalDate.now()))
    }
}
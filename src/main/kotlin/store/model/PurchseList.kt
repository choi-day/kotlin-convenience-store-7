package store.model

class PurchseList {
    fun splitPurchaseList(purcharseData: String): List<List<String>> {
        val purcharseSplitList = purcharseData.split(",")
        val purchaseTempList = purcharseSplitList.map { it.substring(startIndex = 1, endIndex = it.length-2).split("-")}
        return purchaseTempList
    }

    fun getPurchaseList(purcharseData: String, productList: List<Product>): List<Purchase> {
        val purchaseTempList = splitPurchaseList(purcharseData)
        val purchaseList = purchaseTempList.map {Purchase.allocatePurchase(it, productList)}
        return purchaseList
    }
}
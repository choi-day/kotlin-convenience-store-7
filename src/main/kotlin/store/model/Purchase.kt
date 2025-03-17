package store.model

class Purchase(val product: Product, val quantity: Quantity) {
    companion object {
        fun allocatePurchase(purchaseTempList : List<String>, productList: List<Product>) : Purchase{
            val product = productList.find { it.productInfo.name == purchaseTempList[0] }!!
            val quantity = Quantity(purchaseTempList[1].toInt())
            return Purchase(product, quantity)
        }
    }

    //가져온 물건 개수가 프로모션 적용 개수와 다른지 확인
    fun checkPurchasePromotion(): Boolean {
        return quantity.quantity % product.promotion.buy + product.promotion.get == product.promotion.buy
    }

    // 프로모션을 전부 받을 수 있는지
    fun checkQuantity(promotionQuantity: Quantity):Boolean {
        val promotionGetQuantity = quantity.quantity / product.promotion.buy
        return promotionGetQuantity <= promotionQuantity.quantity
    }
}
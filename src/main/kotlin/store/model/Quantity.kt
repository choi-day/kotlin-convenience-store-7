package store.model


class Quantity(var quantity: Int) {
    // 정상가로 지불해야 하는 개수 계산: promotionProduct의 quantity
    fun calculatePaymentQuantity(purchase: Purchase): Quantity{
        val promotionGetQuantity = purchase.quantity.quantity / purchase.product.promotion.buy
        if (promotionGetQuantity < quantity) {
            return Quantity(0)
        }
        return Quantity(promotionGetQuantity - quantity)
    }
}

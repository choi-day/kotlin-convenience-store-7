package store.view

import store.model.Product
import store.model.Purchase
import store.model.Quantity

object Output {
    fun printGreet() = println("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.")
    fun printProductList(name: String, price: String, quantity: Int, promotion: String) {
        print("- ${name} ${price}원 ")
        if (quantity == 0) println("재고 없음 ")
        else print("${quantity}개 ")
        if(promotion == "null") println("")
        else println(promotion)
    }

    fun printPurchaseMessage() {
        println()
        println("구매하실 상품명과 수량을 입력해주세요. (예: [사이다-2],[감자칩-1])")
    }

    fun askAddPurchase(name: String, get: Int) {
        println()
        println("현재 ${name}은(는) ${get}개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)")
    }

    fun askPricePayment(name: String, quantity: Int) {
        println()
        println("현재 {name} {quantity}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)\n")
    }
}

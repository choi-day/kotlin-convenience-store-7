package store.view

import store.model.ProductList

object Output {
    fun printGreet() = println("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.")
    fun printProductList() {
        val productList = ProductList()
        println(productList.splitProduct().joinToString("\n"))// Product 물품 출력
    }
    fun printPurchaseMessage(){
        println("구매하실 상품명과 수량을 입력해주세요. (예: [사이다-2],[감자칩-1])")
    }
}
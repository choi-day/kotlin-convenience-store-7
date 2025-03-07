package store.model

import java.text.DecimalFormat

data class Quantity(var quantity: String) {
    fun nullProcess():String {
        if (quantity == "0") return "재고없음"
        return quantity
    }
//    init {
//        if(quantity.toInt() ==0 ){
//            quantity = "재고 없음"
//        }
//    }
}
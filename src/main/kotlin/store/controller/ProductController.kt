package store.controller

import store.model.ProductList
import store.view.Input
import store.view.Output

class ProductController {
    fun openStore() {
        Output.printGreet()
        val productSplitList = ProductList().splitProductList()
        productSplitList.forEach { it -> Output.printProductList(it.productInfo.name, it.productInfo.getDecimalFormat(), it.quantity.quantity, it.promotion.promotion)}
        getPurchaseList()
    }

    fun getPurchaseList() {
        Output.printPurchaseMessage()
        Input.inputPurchaseList()
    }
}

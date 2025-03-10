package store.controller

import store.model.ProductList
import store.view.Input
import store.view.Output

class ProductController {
    fun openStore() {
        val productList = ProductList()
        Output.printGreet()
        Output.printProductList(productList)
        getPurchaseList()
    }

    fun getPurchaseList() {
        Output.printPurchaseMessage()
        Input.inputPurchaseList()
    }
}

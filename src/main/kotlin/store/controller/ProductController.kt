package store.controller

import store.model.ProductList
import store.view.Input
import store.view.Output

class ProductController {
    fun openStore() {
        Output.printGreet()
        val productSplitList = ProductList().splitProductList()
        Output.printProductList(productSplitList)
        getPurchaseList()
    }

    fun getPurchaseList() {
        Output.printPurchaseMessage()
        Input.inputPurchaseList()
    }
}

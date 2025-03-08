package store.controller

import store.view.Input
import store.view.Output

class ProductController {
    fun openStore() {
        Output.printGreet()
        Output.printProductList()
        getPurchaseList()
    }

    fun getPurchaseList() {
        Output.printPurchaseMessage()
        Input.inputPurchaseList()
    }
}

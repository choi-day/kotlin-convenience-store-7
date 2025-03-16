package store.controller

import ProductInfo
import store.model.ProductList
import store.model.PromotionList
import store.view.Input
import store.view.Output

class ProductController {
    val productList = ProductList().getProductList()
    val promotionList = PromotionList().getPromotionList()

    fun openStore() {
        Output.printGreet()
        productList.forEach {Output.printProductList(
            it.productInfo.name, it.productInfo.getDecimalFormat(), it.quantity.quantity, it.promotion.promotion
        )}
        getPurchaseList()
    }

    fun getPurchaseList(){
        Output.printPurchaseMessage()
        Input.inputPurchaseList()
        print(promotionList.toString())
    }
}

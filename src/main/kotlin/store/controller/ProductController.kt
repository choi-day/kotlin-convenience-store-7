package store.controller

import ProductInfo
import store.model.*
import store.view.Input
import store.view.Output

class ProductController {
    val productList = ProductList().getProductList()
    val promotionList = PromotionList().getPromotionList()
    val promotionProductList = ProductList().getPromotionProductList()
    val originalProductList = ProductList().getOriginalProductList()

    fun openStore() {
        Output.printGreet()
        productList.forEach {Output.printProductList(
            it.productInfo.name, it.productInfo.getDecimalFormat(), it.quantity.quantity, it.promotion.promotion
        )}
        checkPromotionDate(getPurchaseList())
    }

    fun getPurchaseList() : List<Purchase> {
        Output.printPurchaseMessage()
        val purchaseList = PurchseList().getPurchaseList(Input.inputPurchaseList(), productList)
        return purchaseList
    }

    fun checkPromotionDate(purchaseList: List<Purchase>) {
        purchaseList.forEach {
            if (it.product.promotion.checkDate()){checkPromotion(it)}
        }
    }

    fun checkPromotion(purchase: Purchase) {
        //가져온 수량, 프로모션 수량 비교
        val promotion = promotionProductList.find { promotionProduct ->
            promotionProduct.promotion.promotion == purchase.product.promotion.promotion
        }!!
        if(purchase.checkPurchasePromotion()){
            confirmAddPurchase(purchase)
        }

        //구매 수량, 프로모션 적용 수량 비교
        if(!purchase.checkQuantity(promotion.quantity)){
            val paymentQuantity = promotion.quantity.calculatePaymentQuantity(purchase)
            confirmPricePayment(purchase, paymentQuantity)
        }

    }

    //프로모션으로 인한 행사 제품 받기 확인
    fun confirmAddPurchase(purchase: Purchase): Purchase {
        val name = purchase.product.productInfo.name
        val get = purchase.product.promotion.get
        Output.askAddPurchase(name, get)
        if(Input.inputAddPurchase() == "Y"){
            return Purchase(purchase.product, Quantity(purchase.quantity.quantity+get))
        }
        return purchase
    }

    //일반가로 구매해야함을 확인
    fun confirmPricePayment(purchase: Purchase, paymentQuantity: Quantity): Purchase {
        val name = purchase.product.productInfo.name
        Output.askPricePayment(name, paymentQuantity.quantity)
        if(Input.inputAddPurchase() == "Y"){
            return Purchase(purchase.product, Quantity(purchase.quantity.quantity - paymentQuantity.quantity))
        }
        return purchase
    }
 }
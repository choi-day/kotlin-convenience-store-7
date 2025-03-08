package store.model

import ProductInfo

class Product(val productInfo: ProductInfo, var quantity: Quantity, val promotion: Promotion) {
    override fun toString(): String {
        return "- ${productInfo.name} ${productInfo.getDecimalFormat()}원 ${quantity.nullProcess()}개 ${promotion.nullProcess()}"
    }

    companion object {

        // Product 제품에 각각 할당해서 넣는 것
        fun allocateProduct(productList: List<String>): Product {
            val productInfo = ProductInfo(productList.first().toString(), productList[1].toInt())
            val quantity = Quantity(productList[2])
            val promotion = Promotion(productList[3])
            return Product(productInfo, quantity, promotion)
        }

    }

}

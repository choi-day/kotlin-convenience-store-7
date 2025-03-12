package store.model

import ProductInfo

class Product(val productInfo: ProductInfo, val quantity: Quantity, val promotion: Promotion) {

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

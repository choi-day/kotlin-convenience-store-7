package store.model

class Purchase(product: Product, quantaty: Quantity) {
    companion object {
        fun allocatePurchase(purchaseTempList : List<String>, productList: List<Product>) : Purchase{
            val product = productList.find { it.productInfo.name == purchaseTempList[0] }!!
            val quantaty = Quantity(purchaseTempList[2].toInt())
            return Purchase(product, quantaty)
        }
    }
}
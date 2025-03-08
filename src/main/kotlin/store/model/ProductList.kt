package store.model


import java.nio.file.Files
import java.nio.file.Paths

class ProductList {
    var productArrangeList = mutableListOf<Product>()
    val path = Paths.get("src/main/resources/products.md")

    private fun getProductList(): List<String> {
        val productList = Files.lines(path, Charsets.UTF_8).toList()
        return productList
    }

    fun splitProduct():
            MutableList<Product> {
        val productList = getProductList()

        for (i in 1..<productList.size - 1) {
            val product = productList[i].split(",")
            productArrangeList.add(Product.allocateProduct(product))

        }
        return productArrangeList

    }
}

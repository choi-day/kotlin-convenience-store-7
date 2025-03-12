package store.model


import java.nio.file.Files
import java.nio.file.Paths

class ProductList {
    val path = Paths.get("src/main/resources/products.md")

    private fun getProductList(): List<String> {
        val productList = Files.lines(path, Charsets.UTF_8).toList()
        return productList
    }

    fun splitProductList(): List<Product> {
        val productList = getProductList().map{ it.split(",")}
        val productSplitList = productList.subList(1,productList.size).map{Product.allocateProduct(it)}
        return productSplitList
    }
}
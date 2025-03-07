package store.model


import java.nio.file.Files
import java.nio.file.Paths

// 프로덕트파일을 가져오는 역할
class ProductList {
    var productArrangeList = mutableListOf<Product>()
    val path = Paths.get("src/main/resources/products.md")

    // 프로덕트 파일에 있는 제품 목록을 리스트로 반환
    private fun getProductList(): List<String> {
        val productList = Files.lines(path, Charsets.UTF_8).toList()
        return productList
    }

    //  제풀 리스트들을 하나의 제품으로 분리해주는 것 ( 하나의 제품을 리스트 형식으로 반환 -> product )
    // null은 일단 애매해서
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

package store

import store.controller.ProductController
import store.model.Product
import store.model.Product.Companion.allocateProduct
import store.model.ProductList
import java.util.*

fun main() {
    ProductController().openStore()
}

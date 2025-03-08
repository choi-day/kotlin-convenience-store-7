package store.model


data class Quantity(var quantity: String) {
    fun nullProcess(): String {
        if (quantity == "0") return "재고없음"
        return quantity
    }
}

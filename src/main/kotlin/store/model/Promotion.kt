package store.model

data class Promotion(val promotion: String) {
    fun nullProcess():String {
        if (promotion == "null") return ""
        return promotion
    }
}
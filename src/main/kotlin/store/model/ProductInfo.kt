
import java.text.DecimalFormat

class ProductInfo(val name :String, var price :Int){
    fun getDecimalFormat():String {
        val decimalFormat = DecimalFormat("#,###")
        return decimalFormat.format(price)
    }
}


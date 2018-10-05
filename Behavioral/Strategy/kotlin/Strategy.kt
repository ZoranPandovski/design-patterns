class Product(val name: String, val price: Double)

interface BillingStrategy {
    fun getTotal(productList:List<Product>) : Double
}

class NormalStrategy : BillingStrategy {
    override fun getTotal(productList: List<Product>): Double {
        return productList.map { it.price }.sum()
    }
}

class DiscountStrategy(val discount : Double) : BillingStrategy {
    override fun getTotal(productList: List<Product>): Double {
        return productList.map { it.price }.sum() * (1 - discount / 100)
    }

}


fun main(args: Array<String>) {
    val productA = Product("Product A", 10.0)
    val productB = Product("Product B", 25.6)

    val products = listOf<Product>(productA, productB)

    val normalStrategy = NormalStrategy()
    println(normalStrategy.getTotal(products))

    val discountStrategy = DiscountStrategy(10.0)
    println(discountStrategy.getTotal(products))
}


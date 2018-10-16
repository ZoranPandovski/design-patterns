class Product(val name: String, val price: Double)

inline fun getTotal(productList: List<Product>, strategy: (price: Double) -> Double): Double {
    return productList
            .map { strategy(it.price) }
            .sum()
}

fun normalStrategy(price: Double) = price

fun main(args: Array<String>) {
    val productA = Product("Product A", 10.0)
    val productB = Product("Product B", 25.6)

    val products = listOf(productA, productB)

    println(getTotal(products, ::normalStrategy))

    val discount = 25
    println(getTotal(products) {
        it - it * discount / 100
    })
}

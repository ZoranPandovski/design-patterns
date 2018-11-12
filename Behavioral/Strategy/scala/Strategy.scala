case class Product(name: String, price: Double)

sealed trait BillingStrategy {

  def getTotal(products: List[Product]): Double
}

class NormalStrategy extends BillingStrategy {

  override def getTotal(products: List[Product]): Double = {
    products.map(_.price).sum
  }
}

class DiscountStrategy(discount: Double) extends BillingStrategy {

  override def getTotal(products: List[Product]): Double = {
    products.map(_.price).sum * (1 - discount / 100)
  }
}

object Main extends App {

  def functionalStrategy(products: List[Product], f: (List[Product], Double) => Double, discount: Double = 0): Double = f(products, discount)

  override def main(args: Array[String]): Unit = {
    val productA = Product("Product A", 10.0)
    val productB = Product("Product B", 25.6)
    val products = List(productA, productB)

    val normalStrategy = new NormalStrategy()
    println(normalStrategy.getTotal(products))

    val discountStrategy = new DiscountStrategy(10.0)
    println(discountStrategy.getTotal(products))

    // Functional way of strategy pattern realization
    def normalStrategyFunction(productList: List[Product], discount: Double) = productList.map(_.price).sum
    println(functionalStrategy(products, normalStrategyFunction))

    def discountStrategyFunction(productList: List[Product], discount: Double) = productList.map(_.price).sum * (1 - discount / 100)
    println(functionalStrategy(products, discountStrategyFunction, 10.0))
  }
}

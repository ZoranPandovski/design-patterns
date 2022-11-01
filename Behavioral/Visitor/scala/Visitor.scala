
trait Element {
  def accept(visitor: Visitor)
}

trait Visitor {

  def visitElementA(elementA: ElementA)

  def visitElementB(elementB: ElementB)
}


class ElementA extends Element {

  override def accept(visitor: Visitor): Unit = {
    visitor.visitElementA(this)
  }

  def featureOfElementA() = "Feature of element A"

}

class ElementB extends Element {

  override def accept(visitor: Visitor): Unit = {
    visitor.visitElementB(this)
  }

  def featureOfElementB() = "Feature of element B"

}

class ConcreteVisitorAlpha extends Visitor {

  override def visitElementA(elementA: ElementA): Unit = {
    println(f"Concrete Visitor Alpha visiting ${elementA.featureOfElementA()}")
  }

  override def visitElementB(elementB: ElementB): Unit = {
    println(f"Concrete Visitor Alpha visiting ${elementB.featureOfElementB()}")
  }
}

class ConcreteVisitorBeta extends Visitor {

  override def visitElementA(elementA: ElementA): Unit = {
    println(f"Concrete Visitor Beta visiting ${elementA.featureOfElementA()}")
  }

  override def visitElementB(elementB: ElementB): Unit = {
    println(f"Concrete Visitor Beta visiting ${elementB.featureOfElementB()}")
  }
}


object VisitorPattern {
  def main(args: Array[String]): Unit = {
    val elements = Seq(new ElementA(), new ElementB())
    val visitors = Seq(new ConcreteVisitorAlpha(), new ConcreteVisitorBeta())

    elements.foreach(element => {
      visitors.foreach(visitor => {
        element.accept(visitor)
      })
    })
  }
}

abstract class Component {

  var parent: Option[Component] = None

  def add(component: Component): Unit = {}

  def remove(component: Component): Unit = {}

  def operationSum(): Int
}

class LeafValueOne extends Component {

  override def operationSum(): Int = 1

}

class LeafValueTwo extends Component {

  override def operationSum(): Int = 2

}

class LeafValueThree extends Component {

  override def operationSum(): Int = 3

}

class Composite extends Component {

  private var children: List[Component] = List.empty[Component]

  override def add(component: Component): Unit = {
    component.parent = Option(this)
    this.children = this.children :+ component
  }

  override def remove(component: Component): Unit = {
    component.parent = None
    this.children = this.children diff List(component)
  }

  override def operationSum(): Int = {
    this.children.foldLeft(0)((num, component) => component.operationSum() + num)
  }

}


object CompositePattern {

  def main(args: Array[String]) {

    val mainComposite = new Composite()
    val branchAComposite = new Composite()
    val branchBComposite = new Composite()
    val branchABComposite = new Composite()

    mainComposite.add(new LeafValueOne)
    mainComposite.add(branchAComposite)
    mainComposite.add(branchBComposite)

    branchAComposite.add(new LeafValueTwo)
    branchAComposite.add(branchABComposite)
    branchABComposite.add(new LeafValueOne)

    val leafToBeRemoved = new LeafValueOne
    branchBComposite.add(leafToBeRemoved)
    branchBComposite.add(new LeafValueThree)


    println(s"Operation Sum: ${mainComposite.operationSum()}")

    branchBComposite.remove(leafToBeRemoved)

    println(s"Operation Sum after remove: ${mainComposite.operationSum()}")
  }
}
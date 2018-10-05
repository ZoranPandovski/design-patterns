interface Shape {
    fun draw();
}

class ShapeFactory {
    fun getShape(shapeType: String) : Shape =
            when(shapeType) {
                "CIRCLE" -> Circle()
                "RECTANGLE" -> Rectanble()
                "SQUARE" -> Square()
            }
}

class Circle : Shape {
    override fun draw() {
        println("Inside Circle::draw() method");
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Inside Rectangle::draw() method");
    }
}

class Square : Shape {
    override fun draw() {
        println("Inside Square::draw() method");
    }
}

fun main(args: Array<String>) {
    var shapeFactory = ShapeFactory();
    shapeFactory.getShape("CIRCLE");
    shapeFactory.getShape("RECTANGLE");
    shapeFactory.getShape("SQUARE");
}
enum ShapeType {
    case circle
    case rectangle
    case square
}

class ShapeFactory {
    func make(shape: ShapeType) -> Shape {
        switch shape {
        case .circle: return Circle.make()
        case .rectangle: return  Rectangle.make()
        case .square: return Square.make()
        }
    }
}

protocol Shape {
    static func make() -> Shape
}

class Circle: Shape {
    static func make() -> Shape {
        return Circle()
    }
}

class Rectangle: Shape {
    static func make() -> Shape {
        return Rectangle()
    }
}

class Square: Shape {
    static func make() -> Shape {
        return Square()
    }
}


var shapeFactory = ShapeFactory()
shapeFactory.make(shape: .circle)
shapeFactory.make(shape: .rectangle)
shapeFactory.make(shape: .square)

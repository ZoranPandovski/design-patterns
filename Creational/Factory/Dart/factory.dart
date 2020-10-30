import 'dart:math';

abstract class Shape {
  factory Shape(String type) {
    if(type == 'circle') return Circle(2);
    if(type == 'square') return Square(2);
    throw "Can't create $type";
  }
  num get area;
}

class Circle implements Shape {
  final num radius;
  Circle(this.radius);
  num get area => pi * pow(radius, 2);
}

class Square implements Shape {
  final num side;
  Square(this.side);
  num get area => pow(side, 2) / 2;
}

main() {
  try {
    print(Shape('circle').area);
    print(Shape('square').area);
    print(Shape('triangle').area);
  } catch (e) {
    print(e);
  }
}

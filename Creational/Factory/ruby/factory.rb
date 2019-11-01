class Shape
  def to_s
    "I'm #{self.class.name} with #{properties}"
  end

  def properties
    "undefined properties"
  end
end

class Circle < Shape
  def initialize(radius:)
    @radius = radius
  end

  def properties
    "R=#{@radius} and Area=#{Math::PI * @radius**2}"
  end
end

class Rectangle < Shape
  def initialize(a:, b:)
    @a, @b = a, b
  end

  def properties
    "a=#{@a}, b=#{@b} and Area=#{@a*@b}"
  end
end

class Square < Shape
  def initialize(a:)
    @a = a
  end

  def properties
    "a=#{@a} and Area=#{@a**2}"
  end
end

class RandomShapeFactory
  SHAPES = %w(circle rectangle square)

  def self.get_random_shape
    shape = SHAPES.sample
    case shape
    when "circle"
      makeCircle
    when "rectangle"
      makeRectangle
    when "square"
      makeSquare
    end
  end

  def self.makeCircle
    r = rand(10) + 1
    Circle.new(radius: r)
  end

  def self.makeRectangle
    a = rand(10) + 1
    b = rand(10) + 1
    Rectangle.new(a: a, b: b)
  end

  def self.makeSquare
    a = rand(10) + 1
    Square.new(a: a)
  end
end


5.times do |i|
  puts "Shape #{i}: #{RandomShapeFactory.get_random_shape}"
end
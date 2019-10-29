class Rectangle
  DEFAULT_WIDTH = 0
  DEFAULT_HEIGHT = 0

  def initialize
    @width = DEFAULT_WIDTH
    @height = DEFAULT_HEIGHT
  end

  def to_s
    "This is a #{@width}x#{@height} Rectangle"
  end

  def set_width(width)
    @width = width
    self
  end

  def set_height(height)
    @height = height
    self
  end
end

puts Rectangle.new
#=>This is a 0x0 Rectangle

puts Rectangle.new.set_width(5).set_height(10)
#=> This is a 5x10 Rectangle


defmodule ShapeFactory do
    def create(:circle, radius), do: {:circle, radius}
    def create(:rectangle, width, height), do :{:rectangle, width, height}
    def create(:square, size), do: {:square, size}
end

defmodule Shapes do
    circle = ShapeFactory.create(:circle, 5)
    rectangle = ShapeFactory.create(:rectangle, 5)
    square = ShapeFactory.create(:square, 5)
end
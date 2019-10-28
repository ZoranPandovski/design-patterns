class Car
  attr_accessor :manufacturer, :model, :fuel_type, :body_type, :transmission

  def to_s
    "#{body_type} #{manufacturer} #{model} #{fuel_type} #{transmission}"
  end
end

class CarBuilder
  def initialize
    @car = Car.new
  end

  def with_manufacturer(manufacturer)
    @car.manufacturer = manufacturer
    self
  end

  def with_model(model)
    @car.model = model
    self
  end

  def with_fuel_type(fuel_type)
    @car.fuel_type = fuel_type
    self
  end

  def with_body_type(body_type)
    @car.body_type = body_type
    self
  end

  def with_transmission(transmission)
    @car.transmission = transmission
    self
  end

  def build
    @car
  end
end

car = CarBuilder.new.with_manufacturer('Tesla')
                    .with_model("Model S")
                    .with_fuel_type("eletric")
                    .with_body_type("Coupe")
                    .with_transmission("Automatic")
                    .build

puts "My brand new car is a #{car}"

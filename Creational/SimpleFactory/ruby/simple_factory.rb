class BlackCoffee
  def description
    'BlackCoffee'
  end

  def price
    3
  end
end

class Macchiato
  def description
    'Macchiato'
  end

  def price
    4
  end
end

class Latte
  def description
    'Latte'
  end

  def price
    5
  end
end


class CoffeeFactory
  def self.create(coffee_type)
    case coffee_type
    when :black_coffee
      BlackCoffee.new
    when :macchiato
      Macchiato.new
    when :latte
      Latte.new
    else
      raise 'Coffee Type not found'
    end
  end
end

class CoffeeShop
  def initialize
    @products = []
  end

  def menu
    [:black_coffee, :macchiato, :latte]
  end

  def order(coffee_type)
    @products << CoffeeFactory.create(coffee_type)
  end

  def list
    @products.collect {|p| "#{p.description} - #{p.price}"}
  end

  def total
    @products.inject(0){|sum,e| sum + e.price }
  end
end


shop = CoffeeShop.new

menu = shop.menu
puts "Menu >"
puts menu

shop.order(menu[0])
shop.order(menu[1])

puts "Ordered >"
puts shop.list

puts "Total >"
puts shop.total
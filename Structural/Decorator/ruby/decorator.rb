# NOTE: The code was derived from the following article.
# https://medium.com/@dljerome/design-patterns-in-ruby-decorator-b7f2da4153b0

# Here, Coffee represents the base component that can be decorated with new
# behavior.
class Coffee
    attr_accessor :price
end

# The CoffeeWithCream class decorates the Coffee class. It increases the price
# by 0.50 dollars.
class CoffeeWithCream < Coffee
  
    # The constructor of the decorator accepts a coffee object. The coffee object
    # is the component that is to be wraped by this decorator.
    def initialize(coffee)
        @coffee = coffee
    end

    # This decorator extends the behavior of the Coffee class by extending the
    # price method. It increases the price by 0.50 dollars, which is the cost
    # for cream.
    def price
        @coffee.price += 0.50
    end
end

# The CoffeeWithCream class decorates the Coffee class. It increases the price
# by 0.25 dollars.
class CoffeeWithSugar < Coffee
  
    # The constructor of the decorator accepts a coffee object. The coffee object
    # is the component that is to be wraped by this decorator.
    def initialize(coffee)
        @coffee = coffee
    end

    # This decorator extends the behavior of the Coffee class by extending the
    # price method. It increases the price by 0.50 dollars, which is the cost
    # for sugar.
    def price
        @coffee.price += 0.25
    end
  
    # A decorator can not only exten a behavior, it can also provide new behavior.
    # Here, an additional operation called induce_sugar_rush is added. It can
    # then invoked on the wrapped object, that is, decorated coffee object.
    def induce_sugar_rush
        # The code to induce sugar rush goes here.
    end
end

# Here, we create a new Coffee object, wrap it with a CoffeeWithCream decorator,
# and then wrap it with a CoffeeWithSugar decorator.
coffee = Coffee.new
coffee.price = 2.0
coffee = CoffeeWithCream.new(coffee)
coffee = CoffeeWithSugar.new(coffee)

# We can call price and get the total price for coffee, coffee sugar, and coffee
# cream.
puts coffee.price

# The output of this program is shown below.
# 2.75
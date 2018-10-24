require './memento'

class CareTaker
  attr_reader :mementos

  def initialize
    @mementos = []
  end

  def add(memento)
    mementos.push(memento)
  end

  def [](index)
    mementos[index]
  end

end

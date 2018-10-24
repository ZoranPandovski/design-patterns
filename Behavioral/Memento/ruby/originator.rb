require './memento'

class Originator
  attr_accessor :state

  def save
    Memento.new(state)
  end

  def restore(memento)
    state= memento.state
  end
end

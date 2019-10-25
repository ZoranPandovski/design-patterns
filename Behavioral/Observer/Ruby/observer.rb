module Subject
  def initialize
    @observers = []
  end

  def add_observer(observer)
    @observers << observer
  end

  def remove_observer(observer)
    @observers.delete(observer)
  end

  def notify_observers
    @observers.each do |observer|
      observer.update(self)
    end
  end
end

class MagazineStore
  include Subject

  def initialize(name)
    super()
    @name = name
  end

  def new_products!
    notify_observers
  end

  def to_s
    @name
  end
end

class Person
  def initialize(name)
    @name = name
  end

  def update(store)
    puts "#{@name} says: Wow! There's a new magazine on #{store}!"
  end
end

marvel_store = MagazineStore.new('Marvel Comics Store')
dc_store = MagazineStore.new('DC Comics Store')

joey = Person.new('Joey')
chandler = Person.new('Chandler')

marvel_store.add_observer joey
marvel_store.add_observer chandler
dc_store.add_observer joey

marvel_store.new_products!
dc_store.new_products!

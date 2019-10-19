/// Constructors are used for instantiating an object.
/// It initializes the values to the data members of the class 
/// when an object of that class is being created

class Car {
    var model: String
    var year: Int
    var miles: Int


    // MARK: - Constructor

	init(model: String, year: Int, miles: Int) {
		self.model = model
		self.year = year
		self.miles = miles
    }
}
  
// instantiating an object of the class
let obj = Car("Jeep", 2009, 50000)


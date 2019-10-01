# Constructors are used for instantiating an object.
# It initializes the values to the data members of the class 
# when an object of that class is being created

class Car: 
	# constructor 
	def __init__(self, model, year, miles): 
		# self is a reference to the object itself
		self.model = model
		self.year = year
		self.miles = miles
	
	# method for printing data members 
	def printDetails(self): 
		print(self.model, 'has done', self.miles, 'miles')
  
# instantiating an object of the class
obj = Car("Jeep", 2009, 50000)

# calling the instance method
obj.printDetails() 


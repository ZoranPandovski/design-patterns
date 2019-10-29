# Constructors are used for instantiating an object.
# It initializes the values to the data members of the class
# when an object of that class is being created

class Car
	# Constructor
	def initialize(model, year, miles)
		# Variables prefixed with @ are instance variables
    # which belong to the object being constructed
		@model = model
		@year = year
		@miles = miles
  end

	# Method for printing the object as a string
  # When using methods for printing strings like `puts`
  # this will be automatically used
	def to_s
		"#{@model} has done #{@miles} miles"
  end
end

# Instantiating an object of the class
obj = Car.new("Jeep", 2009, 50000)

# Print the object
puts obj
#=> Jeep has done 50000 miles

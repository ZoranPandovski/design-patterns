// Constructors are used for instantiating an object.
// It initializes the values to the data members of the class
// when an object of that class is being created

#include <iostream>
#include <string>

using namespace std;

class Car {
private:
	string model;
	int year;
	int miles;
public:
	// constructor
	Car(string Model, int Year, int Miles) {
		model = Model;
		year = Year;
		miles = Miles;
	}
	// Helper function for printing data members.
	void printDetails() {
		cout<<"Car model: "<<model<<"\n";
		cout<<"Car year: "<<year<<"\n";
		cout<<"Car miles: "<<miles<<"\n";
	}
};

int main() {
	// instantiating an object of the class
	Car myCar("Mercedes", 2010, 50);

	// calling the instance method
	myCar.printDetails();
}


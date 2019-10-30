# include "factory.h"

int main(void)
{
	// Factory needs to know which type of object to return. 
	Computer * myLaptop = ComputerFactory.NewComputer("laptop");
	Computer * myDesktop = ComputerFactory.NewComputer("desktop")

	// If a change is made to any derived class of Computer, or a new Computer subtype is added, the implementation for NewComputer() is the only code that needs to be recompiled. 
	// Everyone who uses the factory will only care about the interface, which should remain consistent throughout the life of the application.
}
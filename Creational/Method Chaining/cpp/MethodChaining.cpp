#include <iostream>
#include <string>

class House
{
private:
	bool door;
	double qm;
	std::string color;

public:
	House* setDoor(bool hasDoor)
	{
	    door = hasDoor;
	    // Return the object for the next method, so it "chains" to it
	    return this;
    }

    House* area(double area)
    {
    	qm = area;
    	return this;
    }

    House* setColor(std::string color)
    {
    	this->color = color;
    	return this;
    }

    void printHouse()
    {
    	// Simply print everything we have
    	printf("Door: %d\nArea: %f qm\nColor: %s", door, qm, color.c_str());
    }
};

int main() 
{
	House* h = (new House())->setDoor(true)->area(150.5)->setColor("red");
	h->printHouse();
}
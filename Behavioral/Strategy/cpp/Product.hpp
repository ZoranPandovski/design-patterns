#ifndef PRODUCT
#define PRODUCT

#include <string>

class Product
{
public:
	std::string name;
	double price;

	Product(const std::string &name, double price)
	{
		this->name = name;
		this->price = price;
	}
};

#endif

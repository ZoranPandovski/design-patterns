#include <iostream>
#include <string>
#include <list>

#include "Product.hpp"
#include "BillingStrategy.hpp"
#include "DiscountStrategy.hpp"
#include "NormalStrategy.hpp"

int main(int argc, char **argv)
{
	Product pa("Product A", 20);
	Product pb("Product B", 10);
	
	std::list<Product> products;
	products.push_front(pa);
	products.push_front(pb);
	
	BillingStrategy *strategy = new NormalStrategy();
	std::cout<<"Normal: "<<strategy->getTotal(products)<<std::endl;
	delete strategy;
	strategy = new DiscountStrategy(10);
	std::cout<<"Discount: "<<strategy->getTotal(products)<<std::endl;
	delete strategy;
}

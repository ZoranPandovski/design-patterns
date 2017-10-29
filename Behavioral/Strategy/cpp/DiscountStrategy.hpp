#ifndef DISCOUNT
#define DISCOUNT

#include "BillingStrategy.hpp"

class DiscountStrategy : public BillingStrategy
{
private:
	double percentage;
public:
	DiscountStrategy(double percentage) : percentage(percentage){}
	
	double getTotal(std::list<Product> products) override
	{
		double sum = 0;
		for (Product &product:products)
			sum += product.price;
		return sum * (1-percentage/100);
	}
};
#endif

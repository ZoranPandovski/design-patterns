#ifndef NORMAL
#define NORMAL

#include "BillingStrategy.hpp"

class NormalStrategy : public BillingStrategy
{
public:
	double getTotal(std::list<Product> products) override
	{
		double sum = 0;
		for (Product &product:products)
			sum += product.price;
		return sum;
	}
};
#endif

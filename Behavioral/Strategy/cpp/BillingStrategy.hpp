#ifndef BILLING_STRATEGY
#define BILLING_STRATEGY

#include <list>
#include "Product.hpp"

class BillingStrategy
{
public:
	virtual ~BillingStrategy() = default;
	virtual double getTotal(std::list<Product> products) = 0;
};

#endif

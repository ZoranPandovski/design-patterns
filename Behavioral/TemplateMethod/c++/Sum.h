#ifndef SUM_H
#define SUM_H 

#include "Operation.h"

class Sum:public Operation
{
public:
	Sum(int x, int y):Operation(x,y){
	}

	int doOperation() override
	{
		return num1 + num2;
	}

	char getCharOperator() override
	{
		return '+';
	}
	
};
#endif
#ifndef SUBTRACTION_H
#define SUBTRACTION_H 

#include "Operation.h"

class Subtraction:public Operation
{
public:
	Subtraction(int x, int y):Operation(x,y){
	}

	int doOperation() override
	{
		return num1 - num2;
	}

	char getCharOperator() override
	{
		return '-';
	}
	
};
#endif
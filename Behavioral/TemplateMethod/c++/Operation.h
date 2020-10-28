#ifndef OPERATION_H
#define OPERATION_H

#include <string>

using namespace std;

class Operation
{
	protected:
		int num1;
		int num2;

	public:
		Operation(int x, int y)
		{
			this->num1 = x;
			this->num2 = y;
		}

		virtual int doOperation() = 0;
		virtual char getCharOperator() = 0;
		string printOperation()
		{
			return "Operation: " + to_string(num1) + getCharOperator() + to_string(num2) + "=" + to_string(doOperation());
		}
};


#endif
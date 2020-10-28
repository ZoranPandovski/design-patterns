#include <iostream>

#include "Subtraction.h"
#include "Sum.h"

using namespace std;

int main()
{
	Operation * operation = new Sum(10,6);
	cout << operation->printOperation() << endl;
	delete operation;

	operation = new Subtraction(20, 7);
	cout << operation->printOperation() << endl;
	delete operation;
	
	return 0;
}
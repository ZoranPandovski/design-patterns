#include "GraphObserver.h"
#include "TableObserver.h"

int main() {
	Group* g1 = new Group(20, 5);
	GraphObserver*  myGraph = new GraphObserver(g1);
	TableObserver*  myTable = new TableObserver(g1);
	myGraph->update();
	myTable->update();

	cout << "Press a key to set the quantity of women to 20" << endl;
	cin.get();

	g1->setQtyWomen(20);
	cout << endl << endl;

	cout << "Press a key to set the quantity of men to 10" << endl;
	cin.get();

	cout << endl << endl;
	g1->setQtyMen(10);

	cin.get();
}

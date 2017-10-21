#include "TableObserver.h"

TableObserver::TableObserver():Observer(NULL){  }
TableObserver::TableObserver(Group *x):Observer(x){   }

 void TableObserver::update() {
	 int total = getGroup()->getQtyMen() + getGroup()->getQtyWomen();
	 int porcentajeH = getGroup()->getQtyMen() * 100 / total;
	 int porcentajeM = getGroup()->getQtyWomen() * 100 / total;

	 cout << "-------------------------- Data Table  ---------------------------" << endl;
	 cout << "Quantity of Men:   \t" << getGroup()->getQtyMen() << endl;
	 cout << "Quantity of Women: \t" << getGroup()->getQtyWomen() << endl;
	 cout << "Total:             \t" << total << endl << endl;

	 cout << "Percentaje of Men:   \t" << porcentajeH << "%" << endl;
	 cout << "Percentaje of Women: \t" << porcentajeM << "%" << endl;
	 cout << "Total:               \t" << 100 << endl;

	 cout << "------------------------------------------------------------------" << endl;
	 cout << endl;
	 cout << endl;
 }
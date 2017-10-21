#include "GraphObserver.h"

GraphObserver::GraphObserver():Observer(NULL){  }
GraphObserver::GraphObserver(Group *x):Observer(x){   }

 void GraphObserver::update() {
	 int total = getGroup()->getQtyMen() + getGroup()->getQtyWomen();
	 int pctMen = getGroup()->getQtyMen() * 100 / total;
	 int pctWomen = getGroup()->getQtyWomen() * 100 / total;

	 cout << endl;
	 cout << "-------------------------- Bar Graph -----------------------------" << endl;
	 for (int j = 1; j<4; j++) {
		 for (int i = 1; i<pctMen / 4; i++) {
			 cout << "#";
		 }
		 if (j == 2) { cout << "    Men: " << pctMen << "%"; }
		 cout << endl;
	 }

	 cout << endl;
	 cout << endl;

	 for (int j = 1; j<4; j++) {
		 for (int i = 1; i<pctWomen / 4; i++) {
			 cout << "#";

		 }
		 if (j == 2) { cout << "    Women: " << pctWomen << "%"; }
		 cout << endl;
	 }

	 cout << "------------------------------------------------------------------" << endl;
	 cout << endl;
	 cout << endl;
 }
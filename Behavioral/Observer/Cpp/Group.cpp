#include "Group.h"

   Group::Group (int x, int y) {
	   this->canHombres= x; 
	   	  this->canMujeres= y; 
   }

    void Group::attach(Observer *obs) {
       v.push_back(obs);
    }

    void Group::setQtyMen(int val) {
        canHombres = val;
        notify();
    }

	 void Group::setQtyWomen(int val) {
        canMujeres = val;
        notify();
    }

    int Group::getQtyWomen() {
        return canMujeres;
    }

	int Group::getQtyMen() {
        return canHombres;
    }

void Group::notify() {
	if (v.size() > 0){
		for (int i = 0; i < v.size(); i++){
          v[i]->update();
	    }
    }
}


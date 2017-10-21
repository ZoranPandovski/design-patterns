#pragma once
#include <iostream>
using namespace std;
#include "Observer.h";
#include <vector>;

class Observer;// para evitar el problema de referencia circular
class Group {
    int canHombres;
    int canMujeres;
    vector <Observer*> v;
  public:
    Group (int , int) ;
    void attach(Observer *) ;
    void setQtyMen(int ) ;
	void setQtyWomen(int ) ;
    int getQtyMen();
	int getQtyWomen();
    void notify() ;
};

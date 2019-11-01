#include <iostream>

using namespace std;

class Candy {
public:
  virtual void Make() = 0;
  virtual ~Candy() { }
 
};
 
class SimpleCandy: public Candy {
public:
  virtual void Make() {
    cout << "Simple chocolate candy!" << endl;
  }
};
 
class CandyDecorator: public Candy {
public:
  CandyDecorator(Candy& decorator):m_Decorator(decorator) {}
 
  virtual void Make() {
    m_Decorator.Make();
  }

private:
  Candy& m_Decorator;
};
 
class WithFruits : public CandyDecorator {
public:
  WithFruits(Candy& decorator):CandyDecorator(decorator) {}
  virtual void Make() 
  {
    CandyDecorator::Make();
    cout << "Added fruits!" << endl;
  }
};
 

int main() {
  Candy* simpleCandy = new SimpleCandy();
  simpleCandy->Make();
 
  Candy* fruityCandy = new WithFruits(*simpleCandy);
  fruityCandy->Make();
  return 0;
}
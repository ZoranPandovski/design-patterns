#include  "Observer.h";

 Observer::Observer(Group* x) {
        subject =x;
        subject->attach(this);    
  }

  Group * Observer::getGroup() {   return subject;  }



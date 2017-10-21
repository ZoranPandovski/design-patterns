#pragma once
#include "Observer.h"
#include "Group.h"

class TableObserver: public Observer {
  public:
	TableObserver();
    TableObserver(Group *);
    void update();
};

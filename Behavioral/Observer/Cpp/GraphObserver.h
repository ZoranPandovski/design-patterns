#pragma once
#include "Observer.h"
#include "Group.h"

class GraphObserver: public Observer {
  public:
	GraphObserver();
    GraphObserver(Group *);
    void update();
};

#pragma once
#include "Group.h";

class Group;// para evitar el problema de rerencia circular

class Observer {
    protected:
      Group* subject;
    public:
       Observer(Group*);
       virtual void update() = 0;
       Group * getGroup();
};

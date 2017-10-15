#include <iostream>
#include "SingletonDesignPattern.h"

Singleton* Singleton::INSTANCE = NULL;

Singleton::Singleton(){ }

Singleton* Singleton::getInstance(){
    if(INSTANCE == NULL)
        INSTANCE = new Singleton;
    return INSTANCE;
}

void Singleton::printSingleton(){
    std::cout << "Singleton Class" << std::endl;
}

#include "SingletonDesignPattern.h"

int main(){
    Singleton* singleton = Singleton::getInstance();
    singleton->printSingleton();
    return 0;
}

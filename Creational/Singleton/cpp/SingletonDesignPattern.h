#ifndef SINGLETONDESIGNPATTERN_H
#define SINGLETONDESIGNPATTERN_H

class Singleton {
    private:
        static Singleton* INSTANCE;
        Singleton();
    public:
        static Singleton* getInstance();
        void printSingleton();
};

#endif

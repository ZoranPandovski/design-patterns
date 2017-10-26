#include <iostream>

//For C++11
using namespace std;


class Iterator {
    public:
        virtual void first() = 0;
        virtual void next() = 0;
        virtual bool isDone() = 0;
        virtual double currentElement() = 0;
};

class Collection {
    public:
        virtual void add(double x)  = 0;
        virtual int size() = 0;
        virtual Iterator* createIterator() = 0;
};

class List:public Collection{
    private:
        double * elem;
        int capacity;
        int free;
    public:
        List(int capacity): free{0},capacity{capacity}, elem{new double[capacity]} {}
        void add(double x){
            if (free<capacity)
                elem[free++] = x;
            else
                cout << "Unable to add list is already full!";
        }
        int size(){
            return free;
        }
        double getElement(int index){
            return elem[index];
        }
        Iterator* createIterator();
        
};


class ListIterator: public Iterator{
    List * list_instance;
    private:
        int index;
    public:
        ListIterator(List * list_inst): index{0}, list_instance{list_inst} {};
        void first(){
            index = 0;
        }
        void next(){
            index++;
        }
        bool isDone(){
            return index == list_instance->size();
        }
        double currentElement(){
            return list_instance->getElement(index);
        }
};


Iterator * List::createIterator(){
    return new ListIterator(this);
}

int main(){
    double values[] = {1.0, 5.5, 3.2, 2.3, 9.8};
    List * list = new List(5);
    for (double x: values)
        list->add(x);
    Iterator* it = list->createIterator();
    for (it->first(); !it->isDone(); it->next()){
        cout << it->currentElement() << " ";
    }
    cout << endl;
    return 0;
}


#include <iostream>

using namespace std;

class Handler {
    protected:
        Handler *next;

    public:
        Handler() { 
            next = NULL; 
        }

        virtual ~Handler() { }

        virtual void request(int value) = 0;

        void setNextHandler(Handler *nextInLine) {
            next = nextInLine;
        }
};

class SpecialHandler : public Handler {
    private:
        int myLimit;
        int myId;

    public:
        SpecialHandler(int limit, int id) {
            myLimit = limit;
            myId = id;
        }

        ~SpecialHandler() { }

        void request(int value) {
            if(value < myLimit) {
                cout << "Handler " << myId << " handled the request with a limit of " << myLimit << endl;
            } else if(next != NULL) {
                next->request(value);
            } else {
                cout << "Sorry, I am the last handler (" << myId << ") and I can't handle the request." << endl;
            }
        }
};

int main () {
    Handler *h1 = new SpecialHandler(10, 1);
    Handler *h2 = new SpecialHandler(20, 2);
    Handler *h3 = new SpecialHandler(30, 3);

    h1->setNextHandler(h2);
    h2->setNextHandler(h3);

    h1->request(18);

    h1->request(40);

    delete h1;
    delete h2;
    delete h3;

    return 0;
}
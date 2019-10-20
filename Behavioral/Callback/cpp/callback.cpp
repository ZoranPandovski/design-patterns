#include <iostream>

using namespace std;

struct CallbackHandler {

    virtual void onCallback() = 0;
};

struct MyCallbackHandler : public CallbackHandler {

    virtual void onCallback() {
        cout << "Callback was invoked!\n";
    }
};

void apply(CallbackHandler* handler) {
    cout << "Inside a function that accepts a callback.\n";
    
    handler->onCallback();
}

int main() {
    cout << "Invoke a function that accepts a callback.\n";
    
    MyCallbackHandler handler;
    apply(&handler);

    return 0;
}
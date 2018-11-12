#include <iostream>
#include "visitor.h"

using namespace std;

int main() {
    DiscountVisitor dv;
    Drink drink(20);
    Candy candy(30);
    Book book(100);

    cout<<dv.visit(&drink)<<endl;
    cout<<dv.visit(&candy)<<endl;
    cout<<dv.visit(&book)<<endl;

    return 0;
}
#include "visitor.h"

Product::Product(double price) : price(price) { }

double Product::getPrice() {
    return price;
}

double Product::accept(DiscountVisitor& dv) {
    return 0;
}

Drink::Drink(double price) : Product(price) { }

double Drink::accept(DiscountVisitor& dv) {
    dv.visit(this);
}

Candy::Candy(double price) : Product(price) { }

double Candy::accept(DiscountVisitor& dv) {
    dv.visit(this);
}

Book::Book(double price) : Product(price) { }

double Book::accept(DiscountVisitor& dv) {
    dv.visit(this);
}
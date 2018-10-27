#include "visitor.h"

double DiscountVisitor::visit(Drink *drink) {
    return drink->getPrice()*(1 - 0.11);
}

double DiscountVisitor::visit(Candy *candy) {
    return candy->getPrice()*(1 - 0.3);
}

double DiscountVisitor::visit(Book *book) {
    return book->getPrice()*(1 - 0.2);
}



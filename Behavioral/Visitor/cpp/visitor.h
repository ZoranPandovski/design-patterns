#ifndef VISITOR_H
#define VISITOR_H

class DiscountVisitor;

class Product {
    double price;
public:
    Product(double price);
    virtual double accept(DiscountVisitor& dv);
    double getPrice();
};

class Drink : public Product{
public:
    Drink(double price);
    double accept(DiscountVisitor& dv);
};

class Candy : public Product{
public:
    Candy(double price);
    double accept(DiscountVisitor& dv);
};

class Book : public Product {
public:
    Book(double price);
    double accept(DiscountVisitor& dv);
};


class DiscountVisitor {
public:
    virtual double visit(Drink *drink);
    virtual double visit(Candy *candy);
    virtual double visit(Book *book);
};

#endif

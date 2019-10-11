#ifndef STACK_H
#define STACK_H
#include "dlist.h"

// This is a C++ demonstration of two types of Adapter design patter:
// 1. Object adapters
// 2. Class adapters
// We will convert a doubly-linked list to a stack

// A simple stack class
class Stack{
public:
	Stack() {

	}
	virtual void push(const int& o)=0;
	virtual void pop()=0;
	virtual int top() const =0;
	virtual bool isEmpty()=0;
	virtual int numItems()=0;
	virtual ~Stack() {

	}
};

// Object Adapters use composition of adaptee to convert interfaces
class ObjectAdapter: public Stack{
private:
	DList* dList_;
public:
	// Instantiate new instance of adaptee
	ObjectAdapter() {
		dList_ = new DList();
	}

	// Call adaptee's push front
	void push(const int& o) {
		dList_->push_front(o);
	}

	// Call adaptee's pop front
	void pop() {
		dList_->pop_front();
	}

	// Create iterator of adaptee, pointed at first item, the return dereferenced value
	int top() const {
		return *(dList_->cbegin());
	}

	// Call adaptee's empty
	bool isEmpty() {
		return dList_->empty();
	}

	// Call adaptee's size
	int numItems() {
		return dList_->size();
	}
	
	// Delete the adaptee object
	~ObjectAdapter() {
		delete dList_;
		dList_ = nullptr;
	}

};

// Class Adapters use inheritance of adaptee to convert interfaces
class ClassAdapter: public Stack, public DList{

	// Call adaptee base class's push front
	void push(const int& o) {
		push_front(o);
	}

	// Call adaptee base class's pop front
	void pop() {
		pop_front();
	}

	// Call adaptee base class's pop front
	int top() const {
		return *cbegin();
	}

	// Create iterator of adaptee base class, pointed at first item, the return dereferenced value
	bool isEmpty() {
		return empty();
	}

	// Call adaptee base class's size
	int numItems() {
		return size();
	}
};
#endif
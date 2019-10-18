package main

import "fmt"

// Iterator interface defines methods for iterator pattern
type Iterator interface {
	// HasNext returns true if there are any items left to be iterated
	HasNext() bool

	// Next returns the next item in the collection
	Next() interface{}
}

// Collection defines interface for collection of items
type Collection interface {
	// Add adds item into the collection
	Add(item interface{})

	// Iterator returns iterator for the Collection
	Iterator() Iterator
}

// List defines list of items
type List struct {
	items []interface{}
}

// ListIterator holds the data needed to iterate a List
type ListIterator struct {
	index int
	items []interface{}
}

func (i *ListIterator) HasNext() bool {
	return i.index < len(i.items)
}

func (i *ListIterator) Next() interface{} {
	if !i.HasNext() {
		return nil
	}

	item := i.items[i.index]
	i.index++
	return item
}

func (c *List) Add(item interface{}) {
	c.items = append(c.items, item)
}

func (c *List) Iterator() Iterator {
	return &ListIterator{items: c.items}
}

func main() {
	list := &List{}
	list.Add(10)
	list.Add(3.14)
	list.Add("hello")

	itr := list.Iterator()
	for ; itr.HasNext(); {
		fmt.Println(itr.Next())
	}

	// prints:
	// 10
	// 3.14
	// hello
}

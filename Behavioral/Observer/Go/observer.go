package main

import "fmt"

// Observer is an interface implemented by observers interested in a subject
type Observer interface {
	Notify()
}

// Subject is an interface implemented by subject that is observable
type Subject interface {
	// RegisterObserver registers the observer passed
	RegisterObserver(observer Observer)

	// NotifyObservers notifies all observers registered so far
	NotifyObservers()
}

type ObserverA struct {
}

type ObserverB struct {
}

func (observer *ObserverA) Notify() {
	fmt.Println("ObserverA: Received notification")
}

func (observer *ObserverB) Notify() {
	fmt.Println("ObserverB: Received notification")
}

// InterestingSubject is an example of Subject interface implementation
type InterestingSubject struct {
	Observers []Observer
}

func (s *InterestingSubject) RegisterObserver(observer Observer) {
	s.Observers = append(s.Observers, observer)
}

func (s *InterestingSubject) NotifyObservers() {
	for _, observer := range s.Observers {
		observer.Notify()
	}
}

func main() {
	subject := &InterestingSubject{}

	subject.RegisterObserver(&ObserverA{})
	subject.RegisterObserver(&ObserverB{})

	subject.NotifyObservers()

	// prints:
	// ObserverA: Received notification
	// ObserverB: Received notification
}

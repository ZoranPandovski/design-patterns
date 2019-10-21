package main

import "fmt"

//FlyWeight is the default interface that all the structs that will be in the pool will need to implement.
type FlyWeight interface {
	Operation()
}

type flyWeight struct {
	state string
}

func (fw *flyWeight) Operation() {
	fmt.Println("State: " + fw.state)
}

//FlyWeightFactory is the struct that will contain the logic to create a new or return an existing instance
//of a FlyWeight based on it's current state
type FlyWeightFactory interface {
	GetFlyWeight(state string) FlyWeight
}

type fwFactory struct {
	flyweights map[string]FlyWeight
}

//NewFlyWeightFactory will return a new FlyWeight factory instance
func NewFlyWeightFactory() FlyWeightFactory {
	return &fwFactory{}
}

func (f *fwFactory) GetFlyWeight(s string) FlyWeight {

	if f.flyweights == nil {
		f.flyweights = make(map[string]FlyWeight)
	}

	if v, ok := f.flyweights[s]; ok {
		return v
	}

	fly := new(flyWeight)
	fly.state = s
	f.flyweights[s] = fly

	return fly
}

func main() {
	factory := NewFlyWeightFactory()
	fw := factory.GetFlyWeight("foo")
	fw.Operation()
}

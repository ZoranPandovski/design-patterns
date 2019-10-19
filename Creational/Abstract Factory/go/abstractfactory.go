package main

import (
	"fmt"
	"strconv"
)

//AnimalSpecies enum
type AnimalSpecies int

//represents all animal species that can be created using this factory
const (
	Duck AnimalSpecies = iota
	Dog
	Cat
)

func (d AnimalSpecies) String() string {
	return [...]string{"Duck", "Dog", "Cat"}[d]
}

//Animal interface has methods describing what a animal can do and the sound that it makes
type Animal interface {
	CanFly() bool
	CanWalk() bool
	CanSwim() bool
	MakeSound()
}

type duck struct {
}

func (d *duck) CanFly() bool {
	return true
}

func (d *duck) CanWalk() bool {
	return true
}

func (d *duck) CanSwim() bool {
	return true
}

func (d *duck) MakeSound() {
	fmt.Println("Quack!")
}

type dog struct {
}

func (d *dog) CanSwim() bool {
	return true
}

func (d *dog) CanWalk() bool {
	return true
}

func (d *dog) CanFly() bool {
	return false
}

func (d *dog) MakeSound() {
	fmt.Println("Bark!")
}

type cat struct {
}

func (c *cat) CanFly() bool {
	return false
}

func (c *cat) CanSwim() bool {
	return false
}

func (c *cat) CanWalk() bool {
	return true
}

func (c *cat) MakeSound() {
	fmt.Println("Meow!")
}

//Create is the function that returns a new instance of animal, based on the enum passed as parameter
func Create(species AnimalSpecies) Animal {
	var a Animal
	switch species {
	case Duck:
		a = &duck{}
	case Dog:
		a = &dog{}
	case Cat:
		a = &cat{}
	}

	return a
}

func main() {

	fmt.Println("Creating a cat")
	a := Create(Cat)
	a.MakeSound()
	fmt.Println("Can a cat fly? " + strconv.FormatBool(a.CanFly()))
	fmt.Println("Can a cat swim? " + strconv.FormatBool(a.CanSwim()))
	fmt.Println("Can a cat walk? " + strconv.FormatBool(a.CanWalk()))
	fmt.Println("--------------------")

	fmt.Println("Creating a dog")
	a = Create(Dog)
	a.MakeSound()
	fmt.Println("Can a dog fly? " + strconv.FormatBool(a.CanFly()))
	fmt.Println("Can a dog swim? " + strconv.FormatBool(a.CanSwim()))
	fmt.Println("Can a dog walk? " + strconv.FormatBool(a.CanWalk()))
	fmt.Println("--------------------")

	fmt.Println("Creating a duck")
	a = Create(Duck)
	a.MakeSound()
	fmt.Println("Can a duck fly? " + strconv.FormatBool(a.CanFly()))
	fmt.Println("Can a duck swim? " + strconv.FormatBool(a.CanSwim()))
	fmt.Println("Can a duck walk? " + strconv.FormatBool(a.CanWalk()))
}

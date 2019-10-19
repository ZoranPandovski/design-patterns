package main

import (
	"fmt"
	"strconv"
)

//NutritionFacts is a interface that is exported for usage outside of this package.
//It has a method to print the whole nutrition facts.
//Note that you can only pass attributes to the nutrifionFacts private struct below via the Builder.
type NutritionFacts interface {
	PrintNutritionFacts()
}

//Private implementation of the NutritionFacts interface
type nutritionFacts struct {
	servingSize  int
	servings     int
	calories     int
	fat          int
	sodium       int
	carbohydrate int
}

func (nf *nutritionFacts) PrintNutritionFacts() {
	fmt.Println("Serving size: " + strconv.Itoa(nf.servingSize))
	fmt.Println("Servings: " + strconv.Itoa(nf.servings))
	fmt.Println("Calories: " + strconv.Itoa(nf.calories))
	fmt.Println("Fat: " + strconv.Itoa(nf.fat))
	fmt.Println("Sodium: " + strconv.Itoa(nf.sodium))
	fmt.Println("Carbohydrate: " + strconv.Itoa(nf.carbohydrate))
}

//NutritionFactsBuilder is the interface responsible for building our NutrictionFacts.
//The recommended way to instantiate a new NutritionFactsBuilder is using the NewNutritionFactsBuilder method.
type NutritionFactsBuilder interface {
	Calories(calories int) NutritionFactsBuilder
	Fat(fat int) NutritionFactsBuilder
	Carbohydrate(carbohydrate int) NutritionFactsBuilder
	Sodium(sodium int) NutritionFactsBuilder
	ServingSize(servingSize int) NutritionFactsBuilder
	Servings(servings int) NutritionFactsBuilder
	Build() NutritionFacts
}

type nfBuilder struct {
	servingSize  int
	servings     int
	calories     int
	fat          int
	sodium       int
	carbohydrate int
}

func (nfb *nfBuilder) Calories(calories int) NutritionFactsBuilder {
	nfb.calories = calories
	return nfb
}

func (nfb *nfBuilder) Fat(fat int) NutritionFactsBuilder {
	nfb.fat = fat
	return nfb
}

func (nfb *nfBuilder) Carbohydrate(carbohydrate int) NutritionFactsBuilder {
	nfb.carbohydrate = carbohydrate
	return nfb
}

func (nfb *nfBuilder) Sodium(sodium int) NutritionFactsBuilder {
	nfb.sodium = sodium
	return nfb
}

func (nfb *nfBuilder) ServingSize(servingSize int) NutritionFactsBuilder {
	nfb.servingSize = servingSize
	return nfb
}

func (nfb *nfBuilder) Servings(servings int) NutritionFactsBuilder {
	nfb.servings = servings
	return nfb
}

func (nfb *nfBuilder) Build() NutritionFacts {
	return &nutritionFacts{
		servingSize:  nfb.servingSize,
		servings:     nfb.servings,
		calories:     nfb.calories,
		fat:          nfb.fat,
		sodium:       nfb.sodium,
		carbohydrate: nfb.carbohydrate,
	}
}

//NewNutritionFactsBuilder is a constructor method that returns a new builder. Using it that way,
//we can pass default values to the builder.
func NewNutritionFactsBuilder() NutritionFactsBuilder {
	return &nfBuilder{
		servings:    1,
		servingSize: 1,
	}
}

func main() {
	builder := NewNutritionFactsBuilder()
	cocaCola := builder.Calories(100).Sodium(35).Carbohydrate(27).Build()
	hamburguer := builder.Calories(200).Sodium(50).Carbohydrate(50).Servings(2).Build()
	cocaCola.PrintNutritionFacts()
	fmt.Println("-----------------------")
	hamburguer.PrintNutritionFacts()
}

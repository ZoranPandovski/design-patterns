package main

import (
	"fmt"
	"math"
	"strconv"
)

//SquarePeg is the struct to be adapt
type SquarePeg struct {
	width float64
}

//RoundHole is the struct that SquarePeg will be adapted to
type RoundHole struct {
	radius int
}

//MakeFit is the function that will adapt a SquarePeg into the RoundHole
//All the conversion logic will be inserted here
func (sp *SquarePeg) MakeFit(rh *RoundHole) {
	amount := sp.width - float64(rh.radius)*math.Sqrt(float64(2))
	if amount < 0 {
		amount = 0
	}
	fmt.Println("reducing square peg of width " + strconv.FormatFloat(sp.width, 'f', 6, 64) + " by " + strconv.FormatFloat(amount, 'f', 6, 64) + " amount")
	if amount > 0 {
		sp.width = sp.width - amount
		fmt.Println("width is now " + strconv.FormatFloat(sp.width, 'f', 6, 64))
	}
}

func main() {
	rh := &RoundHole{radius: 5}
	for i := 6; i < 10; i++ {
		sp := &SquarePeg{width: float64(i)}
		sp.MakeFit(rh)
	}
}

package main

import "fmt"

// Chain defines interface for chain of responsibility pattern
type Chain interface {
	Next(chain Chain)
	Process(value int)
}

// Processor defines struct to hold next item in chain
type Processor struct {
	next Chain
}

// Next sets the next item in chain
func (p *Processor) Next(chain Chain) {
	p.next = chain
}

// ZeroProcessor defines struct to process zero
type ZeroProcessor struct {
	Processor
}

// Process processes zero or else calls next item in the chain
func (p *ZeroProcessor) Process(value int) {
	if value == 0 {
		fmt.Println("ZeroProcessor:", value)
	} else {
		p.next.Process(value)
	}
}

// PositiveProcessor defines struct to process positive integer
type PositiveProcessor struct {
	Processor
}

// Process processes positive integer or else calls next item in the chain
func (p *PositiveProcessor) Process(value int) {
	if value > 0 {
		fmt.Println("PositiveProcessor:", value)
	} else {
		p.next.Process(value)
	}
}

// NegativeProcessor defines struct to process negative integer
type NegativeProcessor struct {
	Processor
}

// Process processes negative integer or else calls next item in the chain
func (p *NegativeProcessor) Process(value int) {
	if value < 0 {
		fmt.Println("NegativeProcessor:", value)
	} else {
		p.next.Process(value)
	}
}

func main() {
	p1 := &ZeroProcessor{}
	p2 := &PositiveProcessor{}
	p3 := &NegativeProcessor{}

	// setup chain
	p1.Next(p2)
	p2.Next(p3)

	p1.Process(10)
	p1.Process(0)
	p1.Process(-10)

	// prints:
	// PositiveProcessor: 10
	// ZeroProcessor: 0
	// NegativeProcessor: -10
}

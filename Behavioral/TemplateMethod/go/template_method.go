package main

import (
	"fmt"
	"strings"
)

type HouseBuilder interface {
	Build()
	buildFoundation()
	buildPillars()
}

type BasicHouse struct {
}

func (h *BasicHouse) Build() {
	h.buildFoundation()
}

func (h *BasicHouse) buildFoundation() {
	fmt.Println("BasicHouse.buildFoundation()")
}

func (h *BasicHouse) buildPillars() {
	fmt.Println("BasicHouse.buildPillars() with basic material")
}

type HouseBuilderTemplate struct {
	template HouseBuilder
}

func (c *HouseBuilderTemplate) Build() {
	c.template.buildFoundation()
	c.template.buildPillars()
}

type LuxuryHouse struct {
	*BasicHouse
}

func (c *LuxuryHouse) buildFoundation() {
	fmt.Println("LuxuryHouse.buildFoundation()")
}

func (c *LuxuryHouse) buildPillars() {
	fmt.Println("LuxuryHouse.buildPillars() from concrete")
}

type WoodenHouse struct {
	*BasicHouse
}

func (c *WoodenHouse) buildFoundation() {
	fmt.Println("WoodenHouse.buildFoundation()")
}

func (c *WoodenHouse) buildPillars() {
	fmt.Println("WoodenHouse.buildPillars() from wood")
}

func main() {
	basicHouse := HouseBuilderTemplate{new(BasicHouse)}
	basicHouse.Build()
	fmt.Println(strings.Repeat("-", 50))

	superHouse := HouseBuilderTemplate{new(WoodenHouse)}
	superHouse.Build()
	fmt.Println(strings.Repeat("-", 50))

	luxury := HouseBuilderTemplate{new(LuxuryHouse)}
	luxury.Build()

	// prints:
	// BasicHouse.buildFoundation()
	// BasicHouse.buildPillars() with basic material
	// --------------------------------------------------
	// WoodenHouse.buildFoundation()
	// WoodenHouse.buildPillars() from wood
	// --------------------------------------------------
	// LuxuryHouse.buildFoundation()
	// LuxuryHouse.buildPillars() from concrete
}

package main

import (
	"fmt"
)

type Vehicle interface {
	hoot() string
}

type Car struct {
	hooterSound string
}

func (c Car) hoot() string {
	return c.hooterSound
}

type Truck struct {
	hornSound string
}

func (t Truck) hoot() string {
	return t.hornSound
}

type VehicleFactory struct{}

func (vf VehicleFactory) getVehicle(vehicleType string) Vehicle {
	switch vehicleType {
	case "Truck":
		return Truck{hornSound: "baarb"}
	default:
		return Car{hooterSound: "beep"}
	}
}

func main() {
	var vf VehicleFactory
	var vehicle1 = vf.getVehicle("Car")
	var vehicle2 = vf.getVehicle("Truck")
	fmt.Println(vehicle1.hoot())
	fmt.Println(vehicle2.hoot())
}

package main

import "./car"

func main() {
    c := new(car.Car)
    c.Color

    // Will throw error
    c.numWheels
    // Will throw error
    c2 := new(car.car)
}

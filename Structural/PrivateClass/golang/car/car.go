package car

type Car struct {
    // Won't be exported (lowercase n)
    numWheels int
    // Will be exported (capital C)
    Color string
}

// Won't be able to be used outside of package
type car struct {}

package main
import "fmt"

// define strategy interface
type Strategy func(int, int) int

type ProductStrategy interface {
    SetStrategy(Strategy)
    GetResult() int
}

// define product structure
type Product struct {
    quantity int
    price int
    strategy Strategy
}

func (s *Product) SetStrategy(strat Strategy) {
    s.strategy = strat
}

func (s *Product) GetResult() int {
    return s.strategy(s.quantity, s.price)
}

func NewProduct(quantity int, price int) ProductStrategy {
    return &Product{quantity: quantity, price: price}
}

// Define the potential strategies
func NormalProductStrategy(quantity int, price int) int {
    return quantity * price
}

func DiscountProductStrategy(quantity int, price int) int {
    // discount takes 20% off
    return int(float64(quantity * price) * .8)
}

func main() {
    // to run:   go run Strategy.go
    // to build: go build Strategy.go
    p := NewProduct(1, 5)
    p.SetStrategy(NormalProductStrategy)
    fmt.Print("NormalProductStrategy: $")
    fmt.Println(p.GetResult())

    p.SetStrategy(DiscountProductStrategy)
    fmt.Print("DiscountProductStrategy: $")
    fmt.Println(p.GetResult())
}

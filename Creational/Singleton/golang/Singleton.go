// Singleton
package main

import (
	"fmt"
	"sync"
)

type singleton struct {
	state string
}

var instance *singleton
var once sync.Once

func GetInstance() *singleton {
	once.Do(func() {
		instance = &singleton{}
	})
	return instance
}

func (s *singleton) GetState() string {
	return s.state
}

func (s *singleton) SetState(state string) {
	s.state = state
}

func main() {
	var State = GetInstance()
	State.SetState("on")
	fmt.Println(State.state)
	var State2 = GetInstance()
	State2.SetState("off")
	fmt.Println(State.state)
}

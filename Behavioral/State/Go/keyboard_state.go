package main

import (
	"fmt"
	"unicode"
)

// KeyboardState defines interface for state pattern
type KeyboardState interface {
	// KeyPressed does the action based on current state of keyboard
	KeyPressed(r rune)
}

// KeyboardContext encapsulates the Keyboard State
type KeyboardContext struct {
	state KeyboardState
}

// KeyPressed switches the state of keyboard based on key pressed
func (ctx *KeyboardContext) KeyPressed(r rune) {
	if r == '^' {
		ctx.state = &UppercaseState{}
		fmt.Println("switched to uppercase state")
	} else if r == '_' {
		ctx.state = &LowercaseState{}
		fmt.Println("switched to lowercase state")
	} else {
		ctx.state.KeyPressed(r)
	}
}

func (ctx *KeyboardContext) SetState(state KeyboardState) {
	ctx.state = state
}

type LowercaseState struct {
}

func (s *LowercaseState) KeyPressed(r rune) {
	fmt.Println("in lowercase state:", string(unicode.ToLower(r)))
}

type UppercaseState struct {
}

func (s *UppercaseState) KeyPressed(r rune) {
	fmt.Println("in uppercase state:", string(unicode.ToUpper(r)))
}

func main() {
	state := &LowercaseState{}
	ctx := &KeyboardContext{state}
	ctx.KeyPressed('a')
	ctx.KeyPressed('^')
	ctx.KeyPressed('a')
	ctx.KeyPressed('_')
	ctx.KeyPressed('A')
	// prints:
	// in lowercase state: a
	// switched to uppercase state
	// in uppercase state: A
	// switched to lowercase state
	// in lowercase state: a
}

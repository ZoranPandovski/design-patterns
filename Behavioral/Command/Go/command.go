package main

import "fmt"

// Command defines interface to command pattern
type Command interface {
	Execute()
}

type LightOn struct {
}

func (lightOn *LightOn) Execute() {
	fmt.Println("Light On ...")
}

type LightOff struct {
}

func (lightOff *LightOff) Execute() {
	fmt.Println("Light Off ...")
}

type RemoteControl struct {
	command Command
}

func (r *RemoteControl) SetCommand(command Command) {
	r.command = command
}

func (r *RemoteControl) ButtonPressed() {
	r.command.Execute()
}

func main() {
	r := &RemoteControl{}

	r.SetCommand(&LightOn{})
	r.ButtonPressed()

	r.SetCommand(&LightOff{})
	r.ButtonPressed()

	// prints:
	// Light On ...
	// Light Off ...
}

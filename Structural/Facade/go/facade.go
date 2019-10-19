package main

import "fmt"

//All of theses are the subsystems of the façade
type cpu struct {
}

func (c *cpu) start() {
	fmt.Println("Starting the CPU")
}
func (c *cpu) execute() {
	fmt.Println("Executing instruction ")
}
func (c *cpu) load() {
	fmt.Println("Loading registers")
}
func (c *cpu) free() {
	fmt.Println("Freeing registers")
}

type randomAcessMemory struct{}

func (m *randomAcessMemory) load(position int, info string) {
	fmt.Println("Loading data into memory")
}

func (m *randomAcessMemory) free(position int, info string) {
	fmt.Println("Freeing data from memory")
}

type hardDrive struct{}

func (h *hardDrive) read(startPosition int, size int) string {
	fmt.Println("Reading data from the HD")
	return "Data"
}
func (h *hardDrive) write(startPosition int, size int) {
	fmt.Println("Writing data into the HD")
}

//End of the subsystems of the façade

//ComputerFacade is the façade that hides all the complexity of the subsystems that makes the computer work
type ComputerFacade struct {
	cpu               cpu
	randomAcessMemory randomAcessMemory
	hardDrive         hardDrive
}

//Boot is the function that is called by the client to turn the computer on. All the complexity
//of this operation is hidden from the user.
func (cf *ComputerFacade) Boot() {
	bootSector := 1
	sectorSize := 240
	fmt.Println("The system is booting...")
	cf.cpu.start()
	hdBootInfo := cf.hardDrive.read(bootSector, sectorSize)
	cf.randomAcessMemory.load(bootSector, hdBootInfo)
	cf.cpu.execute()
	cf.randomAcessMemory.free(bootSector, hdBootInfo)
	fmt.Println("The system finished booting")
}

func main() {
	computerFacade := ComputerFacade{
		cpu:               cpu{},
		randomAcessMemory: randomAcessMemory{},
		hardDrive:         hardDrive{},
	}

	computerFacade.Boot()
}

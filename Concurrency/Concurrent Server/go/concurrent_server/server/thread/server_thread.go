package thread

import (
	"bufio"
	"fmt"
	"net"
	"strconv"
	"strings"
)

type ServerThread struct {
	Id   int
	Conn net.Conn
}

func (thread *ServerThread) Start()  {
	thread.process()
}

func (thread *ServerThread) process() {
	outputLine := ""
	state := 0

	reader := bufio.NewReader(thread.Conn)
	for state < 3  {
		inputLine, err := reader.ReadString('\n')
		fmt.Println("Process entry: " + string(inputLine))
		if err != nil {
			fmt.Errorf(err.Error())
		}
		if inputLine == "" {
			break
		}

		switch state {
		case 0:
			if strings.EqualFold(inputLine, "Hello\n") {
				outputLine = "Hey there"
				state++
			} else {
				outputLine = "ERROR. Expected 'Hello'"
				state = 0
			}
			break
		case 1:
			val, err := strconv.Atoi(strings.TrimSuffix(inputLine, "\n"))
			if err != nil {
				fmt.Errorf(err.Error())
				outputLine = "ERROR int the expected value"
				state = 0
			}
			val--
			outputLine += "" + strconv.Itoa(val)
			state++
			break
		case 2:
			if strings.EqualFold(inputLine, "Goodbye\n") {
				outputLine = "See you later!"
				state++
			} else {
				outputLine = "ERROR. Expected 'Goodbye'"
				state = 0
			}
			break
		default:
			outputLine = "ERROR"
			state = 0
		}
		_, err = thread.Conn.Write([]byte(outputLine + "\n"))
		if err != nil {
			fmt.Errorf(err.Error())
		}
	}
}
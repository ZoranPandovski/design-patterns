package main

import (
	"bufio"
	"fmt"
	"net"
	"os"
	"strings"
)

func main() {
	execute := true
	conn, err := net.Dial("tcp", "127.0.0.1:8082")
	if err != nil {
		fmt.Errorf(err.Error())
	}
	reader := bufio.NewReader(os.Stdin)
	socketReader := bufio.NewReader(conn)

	for execute {
		fmt.Print("Write a message: ")

		text, _, err := reader.ReadLine()
		if err != nil {
			fmt.Errorf(err.Error())
		}

		if text != nil {
			textStr := string(text)
			fmt.Println("ConcurrentServer.Client: " + textStr)
			if strings.EqualFold(textStr, "Goodbye") {
				execute = false
			}
			_, err = fmt.Fprintf(conn, textStr + "\n")
			if err != nil {
				fmt.Errorf(err.Error())
			}
		}


		message, err := socketReader.ReadString('\n')
		if err != nil {
			fmt.Errorf(err.Error())
		}

		fmt.Print("Server: " + message)
	}
	err = conn.Close()
	if err != nil {
		fmt.Errorf(err.Error())
	}
}
package main

import (
	"fmt"
	"github.com/design_patterns/concurrent_server/server/thread"
	"net"
	"time"
)

func main() {
	currentThreadId := 0
	fmt.Println("Launching server...")

	server, err := net.Listen("tcp", ":8082")
	if err != nil {
		fmt.Errorf(err.Error())
	}
	conn, _ := server.Accept()
	if err != nil {
		fmt.Errorf(err.Error())
	}

	for {
		serverThread := thread.ServerThread{
			Id:   currentThreadId,
			Conn: conn,
		}
		go serverThread.Start()
		time.Sleep(30 * time.Second)
		currentThreadId++
	}

	err = conn.Close()
	if err != nil {
		fmt.Errorf(err.Error())
	}
}
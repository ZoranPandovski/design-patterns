package main

import (
	"log"
	"time"
)

func worker(n int, jobs chan int, result chan int) {
	for j := range jobs {
		log.Printf("Worker %v started job %v ", n, j)

		time.Sleep(time.Second * 1) //we use sleep to simulate the work to do

		log.Printf("Worker %v finished job %v ", n, j)

		result <- j * 2 //send result via channel to main thread
	}
}

const (
	noOfWorkers = 3  //noOfWorkers represent concurrent threads processing at once
	noOfJobs    = 10 //noOfJobs represnt total number of jobs to be done
)

func main() {
	log.Print("Lets start the thread pool ..")

	jobs := make(chan int, noOfJobs)
	result := make(chan int, noOfJobs)

	for i := 1; i <= noOfWorkers; i++ {
		go worker(i, jobs, result) //init threads to do the job
	}

	for i := 1; i <= noOfJobs; i++ {
		jobs <- i //init jobs to be done
	}
	close(jobs) //close channel once all jobs initiated

	for i := 0; i < noOfJobs; i++ {
		log.Printf("result %v ", <-result) //print the result
	}

	log.Print("Hurray, All jobs done !")
}

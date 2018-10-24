package main

import (
  "fmt"
  "reflect"
)

type Book struct {
  Title string
  Author string
  Pages int
}

func BookFactory(title string, author string, pages int) Book {
  return Book{title, author, pages}
}

func main() {
	new_book := BookFactory("Harry Potter and the Philosopher's Stone", "J.K. Rawling", 223)
	fmt.Println(new_book)
	fmt.Println(reflect.TypeOf(new_book))
}

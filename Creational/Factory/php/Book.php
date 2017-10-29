<?php

class Book{
    private $title;
    private $author;
    public function __construct($title, $author){
        $this->author = $author;
        $this->title = $title;
    }
    public function getBookDetails(){
        return $this->title.' - '.$this->author;
    }

}
class BookFactory{
    public static function createBook($title, $author){
        return new Book($title, $author);
    }
}
$book1 = BookFactory::createBook("Alice's Adventures in Wonderland", "Lewis Carroll");
$book2 = BookFactory::createBook("The Book of the Courtier", "Baldassare Castiglione");

print_r($book1->getBookDetails());
print_r($book2->getBookDetails());

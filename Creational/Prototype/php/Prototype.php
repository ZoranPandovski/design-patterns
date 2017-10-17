<?php
class Car {
    protected $make;
    protected $category;

    public function __construct($make, $category)
    {
        $this->make = $make;
        $this->category = $category;
    }

    /**
     * @return mixed
     */
    public function getMake()
    {
        return $this->make;
    }

    /**
     * @param mixed $make
     * @return Car
     */
    public function setMake($make)
    {
        $this->make = $make;
        return $this;
    }

    /**
     * @return mixed
     */
    public function getCategory()
    {
        return $this->category;
    }

    /**
     * @param mixed $category
     * @return Car
     */
    public function setCategory($category)
    {
        $this->category = $category;
        return $this;
    }
}

// Testing:
$original = new Car("Toyota", "SUV");
echo $original->getMake(); // Toyota
echo $original->getCategory(); // SUV

// Now we clone the original prototype:
$copy = clone $original;
$copy->setCategory("Sedan"); // changes only the category
echo $copy->getMake(); // Toyota - this was from the original that was cloned
echo $copy->getCategory(); // Sedan (after we overwrote the value)
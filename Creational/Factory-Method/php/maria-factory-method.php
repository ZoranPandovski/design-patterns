<?php

/* Factory and interfaces */

interface ClothesFactory
{
    public function makeClothing();
}

interface Clothing
{
    public function getClothing();
}

class TshirtFactory implements ClothesFactory
{
    public function makeClothing()
    {
        return new Tshirt();
    }
}

class Tshirt extends Clothing
{
    public function getClothing()
    {
        return 'Pretty T-shirt';
    }
}

/* Client */
​
$factory  = new TshirtFactory();
$clothing = $factory->makeClothing();
print $clothing->getClothing(); // Gives a result of "Pretty T-shirt";

<?php
class Observer 
{
    private $name;

    function __construct($name)
    {
        $this->name = $name;
    }

    function fire()
    {
        echo "fire spotted by $this->name" . PHP_EOL;
    }
}
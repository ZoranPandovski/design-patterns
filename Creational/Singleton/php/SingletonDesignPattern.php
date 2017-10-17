<?php

/**
 * Class President
 *
 * Scenario: There can only be one president of a country at a time.
 * Function: Ensures only one object of a particular type/class is ever created.
 */
final class President
{
    private static $instance;

    private function __construct()
    {
        // we hide the constructor - this way you cannot instantiate the object on it's own using "new President();"
    }

    public static function getInstance()
    {
        // If we haven't instantiated ourselves yet, do so:
        if (!self::$instance) {
            self::$instance = new self();
        }

        return self::$instance;
    }
}

// Testing:
$president1 = President::getInstance();
$president2 = President::getInstance();

var_dump($president1 === $president2); // returns true
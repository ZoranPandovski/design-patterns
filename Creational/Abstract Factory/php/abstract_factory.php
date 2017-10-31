<?php

/**
 * Vehicle interface.
 */
interface Vehicle {
    public function drive();
}

class Car implements Vehicle {
    public function drive() {
        print_r("Driving a car");
    }
}

class Airplane implements Vehicle {
    public function drive() {
        print_r("Flying an airplane");
    }
}

class Bicycle implements Vehicle {
    public function drive() {
        print_r("Riding a bicycle");
    }
}

/**
 *  Vehicle abstract factory.
 */
abstract class VehicleFactory {

    public static function getVehicule($option) {

        $vehicle = NULL;

        switch ($option) {
            case "car":
                $vehicle =  new Car();
                break;
            case "airplane":
                $vehicle = new Airplane();
                break;
            case "bicycle":
                $vehicle =  new Bicycle();
                break;
        }

        return $vehicle;
    }
}

/**
 * Launching demo.
 */

 print "<p>";
 $vehicle1 = VehicleFactory::getVehicule("car");
 $vehicle1->drive();
 print "</p>";

 print "<p>";
 $vehicle2 = VehicleFactory::getVehicule("airplane");
 $vehicle2->drive();
 print "</p>";

 print "<p>";
 $vehicle3 = VehicleFactory::getVehicule("bicycle");
 $vehicle3->drive();
 print "</p>";
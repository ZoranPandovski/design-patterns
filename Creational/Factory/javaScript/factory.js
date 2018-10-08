/* 
The **Factory** pattern concerned wit the notion of creating objects. it doesn't explicitly require us to use a constructor. The **Factory** pattern provide a generic interface for creating objects, where we can specify the type of factory object we wish to be created.

**When to use**
* when a object involve a high level of complexity.
* When a high
* When working with high number of object sharing the same properties
* This is useful for decoupling.
*/

/* The pre ES2015 way */
function Car ( options ) {
  this.doors = options.doors || 4;
  this.state = options.state || "brand new";
  this.color = options.color || "silver";
}
function Truck( options) {
  this.state = options.state || "used";
  this.wheelSize = options.wheelSize || "large";
  this.color = options.color || "blue";
}

function VehicleFactory() {}
 
// Our default vehicleClass is Car
VehicleFactory.prototype.vehicleClass = Car;
 
// Creating new Vehicle instances
VehicleFactory.prototype.createVehicle = function ( options ) {
  switch(options.vehicleType) {
    case "car":
      this.vehicleClass = Car;
      break;
    case "truck":
      this.vehicleClass = Truck;
      break;
  } 
  return new this.vehicleClass( options );
};
// Creation of an instance of the factory
var carFactory = new VehicleFactory();
var car = carFactory.createVehicle( {
            vehicleType: "car",
            color: "yellow",
            doors: 6 } );

console.log( car instanceof Car ); // true

/* The ES2015+ way */
class Car {
  constructor({ doors, state, color }) {
    this.doors = doors || 4;
    this.state = state || "brand new";
    this.color = color || "silver";
  }
}

class Truck {
  constructor({state, wheelSize, color }) {
    this.state = state || "used";
    this.wheelSize = wheelSize || "large";
    this.color = color || "blue";
  }  
}

class VehicleFactory {
  constructor(vehicleType){
    this.vehicleClass = Car; // default vehiculeClass
    if (vehicleType === "truck") {               
        this.vehicleClass = Truck;
    } 
  }

  createVehicle(options) {
    switch(options.vehicleType) {
      case "car":
        this.vehicleClass = Car;
        break;
      case "truck":
        this.vehicleClass = Truck;
        break;
    } 
    return new this.vehicleClass( options );
  }
}
//Instatiation
const carFactory = new VehicleFactory();
const car = carFactory.createVehicle( {
            vehicleType: "car",
            color: "red",
            doors: 4 } );

console.log( car instanceof Car ); // true

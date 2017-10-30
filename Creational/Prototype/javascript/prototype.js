 var car = {
   name: "Ford Mustang",
   go: function() {
     console.log("I'm hitting the gas!");
   },
   stop: function() {
     console.log("I'm breaking like a responsible person!");
   }
 }

 // Use Object.create to instantiate a new car
var myCar = Object.create( car );
console.log( myCar.name );

// Object.create also allows us to implement differential inheritance 
// by making use of the second supplied argument on Object.creat
var vehicle = {
  getNumWheels: function() {
    console.log("This vehicle has " + this.numWheels + " wheels.");
  }
}

var newCar = Object.create(vehicle, {
  "id": {
    value: 1,
    enumerable: true
  },
  "numWheels": {
    value: 4,
    enumerable: true
  }
});

newCar.getNumWheels();
/* 
Object Constructors are used to create specific types of objects.
*/

/* The pre ES2015 way */

var newObject = {};

var newObj = Object.create(Object.prototype)

var newObj = new Object();

// 4 ways to assign keys and values to an object.
// Set properties
newObj.somekey = 'Hello World'
// Get properties
var value = newObj.someKey

// Square Bracket Syntax
newObj["someKey"] = "Hello World"
var val = newObj["someKey"] 

// Object.defineProterty
object.defineProterty( newObj, "someKey", {
  value: "someVal",
  writable: true,
  enumerable: true,
  configurable: true
})
// Or
var defineProp = function(obj, key, value){
  var config = {
    value: value,
    writable: true,
    enumerable: true,
    configurable: true
  };
  Object.defineProterty(obj, key, config)
};
// To use,  create a new empty "person" object
var person = Object.create( Object.prototype)

defineProp( perosn, "car", "Delorean")
defineProp( perosn, "dateOfBirth", "1981")

// Object.defineProperties
Object.defineProperties(newObj, {
  "someKey": {
    val: "Hello",
    writable: true
  },
  "secondKey": {
    val: "World",
    writable: false
  },
})

// By prefixing a function with "new" a function can behave like a constructor
function Car(model, year, miles){
  this.model = model;
  this.year = year;
  this.miles = miles;

  this.toString = function() {
    return this.model + " has done " +  this.miles + "miles";
  };
}
var civic = new Car("Honda Civic", 2009, 20000)
console.log( civic.toString() )


/* The ES2015+ way */
class Car {
  constructor({ model, year, miles}) {
    this.model = model,
    this.year = year,
    this.miles = miles
  }
  toString() {
    return `${this.model} has done ${this.miles} miles.`
  }
}

const jeep = new Car("Jeep", 2009, 20000)
console.log( jeep.toString() )
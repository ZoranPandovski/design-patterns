// Prior to es6 (es2016), JavaScript did not support classes, 
// but it did support special functions (constructors) that worked 
// similarly during object creation.

function Person(name, age, gender) {
  // The this keyword references the new object's context
  this.name = name;
  this.age = age;
  this.gender = gender;

  this.info = function() {
    return this.name + " is a " + this.age + " year old " + this.gender + ".";
  }
}

// Create new person instances by calling the Person function with the new keyword
var sam = new Person("Sam", "22", "male");
var sally = new Person("Sally", "45", "female");

// Test the output in your browser or terminal
console.log(sam.info()); // Sam is a 22 year old male.
console.log(sally.info()); // Sally is a 45 year old female.
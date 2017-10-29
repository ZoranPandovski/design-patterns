// Note: This is using the es6 class syntax
class Person {
  // Named constructor method takes the place of the generic construction function used in es5
  constructor(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;

    this.info = function() {
      return this.name + " is a " + this.age + " year old " + this.gender + ".";
    }
  }
}

// Create new person instances by calling the Person function with the new keyword
const sam = new Person("Sam", "22", "male");
const sally = new Person("Sally", "45", "female");

// Test the output in your browser or terminal
console.log(sam.info()); // Sam is a 22 year old male.
console.log(sally.info()); // Sally is a 45 year old female.
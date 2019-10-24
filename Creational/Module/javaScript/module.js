const module = (() => {
  this.name = 'Joe';                // private variable, if we wan't get we must use public getter method;

  const getName = () => this.name;  // public;
  const setName = name => {         // public;
    this.name = name
  };

  const privateToUpperCase = () => { // this is private method we have no access to this;
    this.name = this.name.toUpperCase();
  }
  const makeNameUpperCase = () => { // public
    privateToUpperCase();
  }

  return {
    getName,
    setName,
    makeNameUpperCase,
  }
})()

console.log(module.getName())  // return name
module.setName("John") // set passed name 
module.makeNameUpperCase() // make name uppercase
console.log(module.getName()) // return name
console.log(module.name) // return undefined because we have no acces to private variable
module.privateToUpperCase() // error because we have no acces to private method
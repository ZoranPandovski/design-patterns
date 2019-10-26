// User object
const User = function() {
  this.firstname = "";
  this.lastname = "";

  this.saveState = function() {
    return new UserState(this);
  };

  this.restoreState = function(_obj) {
    this.firstname = _obj.firstname;
    this.lastname = _obj.lastname;
  };
};

// Memento Object
const UserState = function(_obj) {
  this.firstname = _obj.firstname;
  this.lastname = _obj.lastname;
};

// CareTaker Object
const CareTaker = function() {
  var conState = null;
  this.SetContractorState = function(_conState) {
    conState = _conState;
  };
  this.GetContractorState = function() {
    return conState;
  };
};

const user = new User();

user.firstname = "firstname";
user.lastname = "lastname";

const careTaker = new CareTaker();
careTaker.SetContractorState(user.saveState());

user.firstname = "firstname2";
user.lastname = "lastname2";

console.log(user);

user.restoreState(careTaker.GetContractorState());

console.log(user);

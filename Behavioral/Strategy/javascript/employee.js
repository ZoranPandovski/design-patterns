const Employee = function() {
  this.roleDescription;
};

Employee.prototype = {
  setStrategy: roleDescription => {
    this.roleDescription = roleDescription;
  },

  print: role => {
    return this.roleDescription.print(role);
  }
};

module.exports = Employee;

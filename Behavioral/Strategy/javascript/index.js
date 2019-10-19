const DeveloperStrategy = require("./developer");
const AdministrationStrategy = require("./administration");
const EmployeeContext = require("./employee");

const dev = new DeveloperStrategy();
const adm = new AdministrationStrategy();

const emp = new EmployeeContext();

emp.setStrategy(dev);
let out = emp.print("developer");
console.log(out);

emp.setStrategy(adm);
out = emp.print("administration");
console.log(out);

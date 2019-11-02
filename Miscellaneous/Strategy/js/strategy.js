const Shipping = () => this.company = "";

Shipping.prototype = {
  setStrategy = companyStrategy => {
    this.company = companyStrategy;
  },
  calculate = package => {
    return this.company.calculate(package);
  }
}

const UPS = () => {
  this.calculate = package => "$45.95";
}

const FEDEX = () => {
  this.calculate = package => "$43.20";
}
const run = () => {
  var package = { from: "76712", to: "10012", weigth: "lkg" };
 

  var ups = new UPS();
  var fedex = new FEDEX();

  var shipping = new Shipping();

  shipping.setStrategy(ups);
  console.log("UPS Strategy: " + shipping.calculate(package));

  shipping.setStrategy(fedex);
  console.log("Fedex Strategy: " + shipping.calculate(package));

}
window.onload = function () {
  let view = new View();
  let ship = new PirateShip();
  let controller = new Controller(view, ship);
  controller.bindListeners();
};

let Controller = function (display, model) {
  this.display = display;
  this.model = model;
}

Controller.prototype = {
  bindListeners() {
    let button = this.display.getButton();
    button.addEventListener('click', this.moveModel.bind(this));
  },

  moveModel() {
    this.model.incrementLocation();
    let newLocation = this.model.location;
    this.display.setShipLocation(newLocation);
  },
};

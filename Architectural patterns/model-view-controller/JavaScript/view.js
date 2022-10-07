let View = function () {
  this.shipSelector = '#pirateShipImage';
  this.buttonSelector = 'button';
};

View.prototype = {
  getShip() {
    return document.querySelector(this.shipSelector);
  },
  setShipLocation(location) {
    let ship = this.getShip();
    ship.style.left = location;
  },
  getButton() {
    return document.querySelector(this.buttonSelector)
  },
};
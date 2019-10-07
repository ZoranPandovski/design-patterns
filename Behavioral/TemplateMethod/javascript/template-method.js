"use strict";
class HouseTemplate {
  constructor() {}
  buildFoundations() {
    console.log("Building Foundations");
  }
  buildHouse() {
    this.buildFoundations();
    this.buildPillars();
    this.buildWalls();
    this.buildWindows();
  }
  buildFoundations() {
    console.log("Building foundations");
  }
  /**
   * Default implementation
   */
  buildWindows() {
    console.log("I am done with building windows");
  }
  buildPillars() {
    throw new Error("You have to build your own pillars");
  }
  buildWalls() {
    throw new Error("You have to build your own walls");
  }
}
module.exports = HouseTemplate;

/* Concrete class for Wooden House */

("use strict");
var HouseTemplate = require("./house-template");

class WoodenHouse extends HouseTemplate {
  constructor() {
    super();
  }

  buildWalls() {
    console.log("Building walls for wooden house");
  }

  buildPillars() {
    console.log("Building pillars for wooden house");
  }
}
module.exports = WoodenHouse;

/* Concrete class for Brick House */

("use strict");

var HouseTemplate = require("./house-template");
class BrickHouse extends HouseTemplate {
  constructor() {
    super();
  }

  buildWalls() {
    console.log("Building walls for brick house");
  }

  buildPillars() {
    console.log("Building pillars for brick house");
  }
}
module.exports = BrickHouse;

const woodenHouse = require("./wooden-house");
const brickHouse = require("./brick-house");
var WoodenHouse = new woodenHouse();
WoodenHouse.buildHouse();
console.log("********---**********");
var BrickHouse = new brickHouse();
BrickHouse.buildHouse();

/* Expected Output */

/*
Building foundations
Building pillars for wooden house
Building walls for wooden house
I am done with building windows
******** — -**********
Building foundations
Building pillars for brick house
Building walls for brick house
I am done with building windows
*/

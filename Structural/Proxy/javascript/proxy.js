/**
 * Implementation of Proxy Pattern using JavaScript (ES6 Syntax).
 * Use Case: Caching requests using proxy
 * */

class GeoLocation {
  getLatLng = (address) => {
    console.log("\n Retrieved value from source \n");
    switch (address) {
      case "Amsterdam":
        return "52.3700° N, 4.8900° E";
      case "London":
        return "51.5171° N, 0.1062° W";
      case "Paris":
        return "48.8742° N, 2.3470° E";
      case "Berlin":
        return "52.5233° N, 13.4127° E";
      default:
        return "";
    }
  };
}

class GeoLocationProxy {
  constructor() {
    this.geolocation = new GeoLocation();
    this.geocache = {};
  }
  getLatLng = (address) => {
    // only call real method if we encounter a cache miss
    if (!this.geocache[address])
      this.geocache[address] = this.geolocation.getLatLng(address);
    else console.log("\n Retrieved value from cache \n");
    // return data from cache
    return this.geocache[address];
  };

  getCount = () => Object.keys(this.geocache).length;
}

const run = () => {
  var geo = new GeoLocationProxy();
  console.log("Paris" + " : " + geo.getLatLng("Paris"));
  console.log("London" + " : " + geo.getLatLng("London"));
  console.log("London" + " : " + geo.getLatLng("London"));
  console.log("Amsterdam" + " : " + geo.getLatLng("Amsterdam"));
  console.log("Amsterdam" + " : " + geo.getLatLng("Amsterdam"));
  console.log("London" + " : " + geo.getLatLng("London"));
  console.log("\nCache size: " + geo.getCount());
};

run();

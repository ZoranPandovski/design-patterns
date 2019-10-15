class Mediator {
  send(user, message) {
    console.log(`${user} said ${message}`);
  }
}

class Animal {
  constructor(name, mediator) {
    this.name = name;
    this.mediator = mediator;
  }

  send(message) {
    this.mediator.send(this.name, message);
  }
}

const mediator = new Mediator();

const dog = new Animal('Dog', mediator);
const cat = new Animal('Cat', mediator);

dog.send('hi cat');
cat.send('hi dog');

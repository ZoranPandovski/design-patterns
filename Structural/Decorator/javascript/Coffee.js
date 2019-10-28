class DrinkIndigrient {
    constructor(drink) {
        this._coffee = drink;
    }
    getDescription() {
        throw new Error('You have to implement the method');
    }
    getCost() {
        throw new Error('You have to implement the method');
    }
}

class SimpleCoffee extends DrinkIndigrient {
    getCost()
    {
        return 10;
    }

    getDescription()
    {
        return 'Simple coffee';
    }
}

class Milk extends DrinkIndigrient {

    constructor(drink) {
        super(drink);
    }

    getCost()
    {
        return this._coffee.getCost() + 3;
    }

    getDescription()
    {
        return this._coffee.getDescription() + ', milk';
    }
}

class Sugar extends DrinkIndigrient {

    constructor(drink) {
        super(drink);
    }

    getCost()
    {
        return this._coffee.getCost() + 2;
    }

    getDescription()
    {
        return this._coffee.getDescription() + ', sugar';
    }
}
var coffee = new SimpleCoffee();
console.log(coffee.getCost()); // 10
console.log(coffee.getDescription()); // Simple Coffee

coffee = new Milk(coffee);
console.log(coffee.getCost()); // 13
console.log(coffee.getDescription()); // Simple Coffee, milk

coffee = new Sugar(coffee);
console.log(coffee.getCost()); // 15
console.log(coffee.getDescription()); // Simple Coffee, milk, sugar
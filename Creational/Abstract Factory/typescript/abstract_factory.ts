interface AbstractProductA {
  usefulFunctionA(): string;
}

interface AbstractProductB {
  usefulFunctionB(): string;

  anotherUsefulFunctionB(collaborator: AbstractProductA): string;
}

interface AbstractFactory {
  createProductA(): AbstractProductA;

  createProductB(): AbstractProductB;
}

class ConcreteProductA1 implements AbstractProductA {
  usefulFunctionA(): string {
    return "The result of the product A1.";
  }
}

class ConcreteProductA2 implements AbstractProductA {
  usefulFunctionA(): string {
    return "The result of the product A2.";
  }
}

class ConcreteProductB1 implements AbstractProductB {
  usefulFunctionB(): string {
    return "The result of the product B1.";
  }

  anotherUsefulFunctionB(collaborate: AbstractProductA): string {
    const result = collaborate.usefulFunctionA();
    return `The result of the B1 collaborating with the ${result}`;
  }
}

class ConcreteProductB2 implements AbstractProductB {
  usefulFunctionB(): string {
    return "The result of the product B2.";
  }

  anotherUsefulFunctionB(collaborate: AbstractProductA): string {
    const result = collaborate.usefulFunctionA();
    return `The result of the B2 collaborating with the ${result}`;
  }
}

class ConcreteFactory1 implements AbstractFactory {
  public createProductA(): AbstractProductA {
    return new ConcreteProductA1();
  }

  public createProductB(): AbstractProductB {
    return new ConcreteProductB1();
  }
}

class ConcreteFactory2 implements AbstractFactory {
  public createProductA(): AbstractProductA {
    return new ConcreteProductA2();
  }

  public createProductB(): AbstractProductB {
    return new ConcreteProductB2();
  }
}

function consumer(factory: AbstractFactory) {
  const productA = factory.createProductA();
  const productB = factory.createProductB();

  console.log(productB.usefulFunctionB());
  console.log(productB.anotherUsefulFunctionB(productA));
}

console.log("Client: Testing client code with the first factory type...");
consumer(new ConcreteFactory1());

console.log("");

console.log(
  "Client: Testing the same client code with the second factory type..."
);
consumer(new ConcreteFactory2());

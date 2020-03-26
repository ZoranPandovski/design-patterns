export namespace factoryMethodExample {
  interface CarInterface {
    drive(): string
    getName(): string
  }
  
  class Car implements CarInterface {
    constructor(private _name: string) {}
  
    public drive() {
      return 'Vrummmmm...'
    }
  
    public getName(): string {
      return `Car: ${this.name}`
    }
  
    public get name(): string {
      return this._name;
    }
  }
  
  class Amarok extends Car {
    constructor(name: string) { super(name) }
  }
  
  class HB20 extends Car {
    constructor(name: string) { super(name) }
  }
  
  class Prisma extends Car {
    constructor(name: string) { super(name) }
  }
  
  type CarType = 'Amarok' | 'HB20' | 'Prisma' | 'Car';
  
  abstract class CarFactory {
    // factory method
    public static create(car: CarType | undefined = undefined): CarInterface {
      let instance: CarInterface;
      switch (car) {
        case 'Amarok':
          instance = new Amarok('Amarok');
          break;
        case 'HB20':
          instance = new HB20('HB20');
          break;
        case 'Prisma':
          instance = new Prisma('Prisma');
          break;
        default:
          instance = new Car('Car');
          break;
      }
  
      return instance;
    }
  }
  
  const car1: CarInterface = CarFactory.create('Amarok');
  const car2: CarInterface = CarFactory.create('HB20');
  const car3: CarInterface = CarFactory.create('Prisma');
  const car4: CarInterface = CarFactory.create();
  
  [car1, car2, car3, car4].forEach(carro => {
    console.log(`${carro.getName()} - ${carro.drive()}`)
  });
}
interface CoffeInterface {
  details(): string
}

@MilkCoffe
@WhipCoffe
@VanillaCoffe
class Coffe implements CoffeInterface {
  public constructor(private _cost: number, private _description: string) {}
  
  public get cost(): number {
    return this._cost
  }

  public get description(): string {
    return this._description
  }

  public details(): string {
    return `
    Desc: ${this.description}
    Price: ${this.cost.toFixed(2)} $`
  }
}

type Constructor = { new(...args: any[]): {} }

function MilkCoffe<T extends Constructor>(constructor: T) {
  return class extends constructor {
    constructor(...args: any[]) {
      let [cost, description] = args
      cost += 2
      super(cost, `${description} + milk`)
    }
  }
}

function WhipCoffe<T extends Constructor>(constructor: T) {
  return class extends constructor {
    constructor(...args: any[]) {
      let [cost, description] = args
      cost += 5
      super(cost, `${description} + whip`)
    }
  }
}

function VanillaCoffe<T extends Constructor>(constructor: T) {
  return class extends constructor {
    constructor(...args: any[]) {
      let [cost, description] = args
      cost += 3
      super(cost, `${description} + vanilla`)
    }
  }
}

const coffe: CoffeInterface = new Coffe(5, 'Coffe Starbucks')

console.log(coffe.details())

/* example IOC (Inversion Of Control) resolved by Container DI */

import 'reflect-metadata' // use reflect to get metadata classes

export namespace inversionOfControlExample {
  interface Type<T> {
    new(...args: any[]): T
  }

  type GenericClassDecorator<T> = (target: T) => void

  // decorator to services
  const Service = () : GenericClassDecorator<Type<object>> => {
    return (target: Type<object>) : void => {
      Ioc.getInstance().store(target)
    }
  }

  class Ioc {
    // singleton
    private static _instance: Ioc = new Ioc
    private _container: Array<Type<object>> = new Array<Type<object>>()

    private constructor() {}

    public static getInstance(): Ioc {
      return Ioc._instance
    }

    public store(target: Type<any>) {
      this._container.push(target)
    }

    public resolve<T>(target: Type<any>): T {
      const tokens = Reflect.getMetadata('design:paramtypes', target) || []
      const injections = tokens.map((token: any) => Ioc.getInstance().resolve(token))
      return new target(...injections)
    }
  }

  export namespace Pay {
    export interface PaymentInterface {
      typePayment: string
    }

    @Service()
    export class CreditCard implements PaymentInterface {
      public typePayment: string = 'CreditCard'
    }

    @Service()
    export class PaymentSlip implements PaymentInterface {
      public typePayment: string = 'PaymentSlip'
    }

    @Service()
    export class BankTransfer implements PaymentInterface {
      public typePayment: string = 'BankTransfer'
    }
  }

  // core domain
  export namespace Buy {
    export interface ProductInterface {
      name: string
      price: number
    }

    export class Product implements ProductInterface {
      constructor(private _name: string, private _price: number) {}

      public get name(): string { return this._name }

      public set name(value: string) { this._name = value }

      public get price(): number { return this._price }

      public set price(value: number) { this._price = value }
    }
    
    @Service()
    export class Order<T extends ProductInterface> {
      private _products: Array<T> = new Array<T>()

      // dependency injection by constructor
      constructor(private _payment: Pay.PaymentInterface) {}

      public addProduct(product: T) {
        this._products.push(product)
      }

      public resume(): void {
        console.log(`Payment method: ${this._payment.typePayment}`)
        this._products.forEach(product => {
          console.log(`Product: ${product.name}`)
          console.log(`Price: ${product.price.toFixed(2)} $`)
        })
      }
    }
  }

  export namespace Factory {
    export abstract class OrderCreditCard {
      public static create(container: Ioc) {
        const creditCard: Pay.CreditCard =
          container.resolve<Pay.CreditCard>(Pay.CreditCard)
        return new Buy.Order(creditCard)
      }
    }

    export abstract class OrderBankTransfer {
      public static create(container: Ioc) {
        const bankTransfer: Pay.BankTransfer =
          container.resolve<Pay.BankTransfer>(Pay.BankTransfer)
        return new Buy.Order(bankTransfer)
      }
    }

    export abstract class OrderPaymentSlip {
      public static create(container: Ioc) {
        const paymentSlip: Pay.PaymentSlip =
          container.resolve<Pay.PaymentSlip>(Pay.PaymentSlip)
        return new Buy.Order(paymentSlip)
      }
    }
  }

  const products: Array<Buy.ProductInterface>= [
    new Buy.Product('Coke', 7.60),
    new Buy.Product('Cheetos', 9.15),
    new Buy.Product('Ice Cream', 15.15),
    new Buy.Product('Doritos', 10.20),
  ]

  // get container DI
  const container: Ioc = Ioc.getInstance()

  // inject dependency payment with credit card resolved by container DI
  const order1: Buy.Order<Buy.ProductInterface> = Factory.OrderCreditCard.create(container)

  order1.addProduct(products[0])
  order1.addProduct(products[1])
  order1.addProduct(products[2])

  order1.resume()

  // inject dependency payment with bank transfer resolved by container DI
  const order2: Buy.Order<Buy.ProductInterface> = Factory.OrderBankTransfer.create(container)

  order2.addProduct(products[0])
  order2.addProduct(products[0])
  order2.addProduct(products[1])
  order2.addProduct(products[2])
  order2.addProduct(products[2])

  order2.resume()
}
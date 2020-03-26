export namespace dependencyInjectionExample {
  export namespace Pay {
    export interface PaymentInterface {
      typePayment: string
    }
  
    export class CreditCard implements PaymentInterface {
      public typePayment: string = 'CreditCard'
    }
  
    export class PaymentSlip implements PaymentInterface {
      public typePayment: string = 'PaymentSlip'
    }
  
    export class BankTransfer implements PaymentInterface {
      public typePayment: string = 'BankTransfer'
    }
  }
  
  export namespace Buy {
    interface ProductInterface {
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
  
  const paymentCard: Pay.PaymentInterface = new Pay.CreditCard()
  const paymentBank: Pay.PaymentInterface = new Pay.BankTransfer()
  
  // inject dependency payment with credit card
  const order1: Buy.Order<Buy.Product> = new Buy.Order<Buy.Product>(paymentCard)
  
  order1.addProduct(new Buy.Product('Coke', 7.60))
  order1.addProduct(new Buy.Product('Cheetos', 9.15))
  order1.addProduct(new Buy.Product('Doritos', 10.20))
  
  // inject dependency payment with bank transfer
  const order2: Buy.Order<Buy.Product> = new Buy.Order<Buy.Product>(paymentBank)
  
  order2.addProduct(new Buy.Product('Hair Cream', 6.20))
  order2.addProduct(new Buy.Product('Ice Cream', 10.95))
  order2.addProduct(new Buy.Product('Beer Heineken', 2.20))
  order2.addProduct(new Buy.Product('French Fries', 5.25))
  
  order1.resume()
  console.log() // space
  order2.resume()
}
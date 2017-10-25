export namespace FactoryMethodPattern {
   abstract class AbstractProduct {
      abstract method(param?: any): void;
   }

   class ConcreteProductEven implements AbstractProduct {
      public method(param?: any) {
         console.log("Method from ConcreteProductEven");
      }
   }

   class ConcreteProductOdd implements AbstractProduct {
      public method(param?: any) {
         console.log("Method from ConcreteProductOdd");
      }
   }

   class ConcreteCreator {
      public static factoryMethod(n: number): AbstractProduct {
         return n % 2 == 0 ? new ConcreteProductEven() : new ConcreteProductOdd();
      }
   }

   export function demo(): void {
      const concreteProductEven: AbstractProduct = ConcreteCreator.factoryMethod(0);
      const concreteProductOdd: AbstractProduct = ConcreteCreator.factoryMethod(1);

      concreteProductEven.method();
      concreteProductOdd.method();
   }
}

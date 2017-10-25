export namespace StatePattern {
   abstract class State {
      abstract handle(context: Context): void;
   }

   class ConcreteStateA implements State {
      public handle(context: Context): void {
         console.log("Handle method for: ConcreteStateA");
         context.State = new ConcreteStateB();
      }
   }

   class ConcreteStateB implements State {
      public handle(context: Context): void {
         console.log("Handle method for: ConcreteStateB");
         context.State = new ConcreteStateC();
      }
   }

   class ConcreteStateC implements State {
      public handle(context: Context): void {
         console.log("Final state");
         context.State = this;
      }
   }

   class Context {
      private state: State;

      constructor(state: State) {
         this.state = state;
      }

      get State(): State {
         return this.state;
      }

      set State(state: State) {
         this.state = state;
      }

      public request(): void {
         console.log("request is being called!");
         this.state.handle(this);
      }
   }

   export function demo(): void {
      const concreteStateA = new ConcreteStateA();
      const context: Context = new Context(concreteStateA);

      context.request();
      context.request();
      context.request(); // infinite loop to final state
   }
}
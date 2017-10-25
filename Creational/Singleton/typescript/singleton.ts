export namespace SingletonPattern {
   class Singleton {
      private static instance: Singleton;

      constructor() { }

      static get Instance() {
         if (!this.instance) {
            this.instance = new Singleton();
         }
         return this.instance;
      }
   }

   export function demo(): void {
      const s1 = Singleton.Instance;
      const s2 = Singleton.Instance;

      if (s1 === s2) {
         console.log("this is a singleton");
      }
   }
}
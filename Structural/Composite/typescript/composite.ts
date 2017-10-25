export namespace CompositePattern {
   abstract class Component {
      protected childrens: Component[];
      protected s: String;

      constructor(s: String) {
         this.s = s;
      }

      abstract operation(): void;
      add(c: Component): void { throw new Error("Not implemented") };
      remove(i: number): void { throw new Error("Not implemented") };
      getChild(i: number): Component { throw new Error("Not implemented") };
   }

   class Composite extends Component {
      constructor(s: string) {
         super(s);
         this.childrens = [];
      }

      public operation(): void {
         console.log("Operation from: ", this.s);
         this.childrens.forEach(children => {
            children.operation();
         });
      }

      public add(c: Component): void {
         this.childrens.push(c);
      }

      public remove(i: number): void {
         if (this.childrens.length <= i) {
            throw new Error("index out of bound!");
         }
         this.childrens.splice(i, 1);
      }

      public getChild(i: number): Component {
         if (this.childrens.length <= i) {
            throw new Error("index out of bound!");
         }
         return this.childrens[i];
      }
   }

   class Leaf extends Component {
      constructor(s: String) {
         super(s);
      }
      public operation(): void {
         console.log("Operation called for Leaf: ", this.s);
      }
   }

   export function demo(): void {
      const leaf1 = new Leaf("A");
      const leaf2 = new Leaf("B");
      const leaf3 = new Leaf("C");
      const composite1 = new Composite("Comp1");
      const composite2 = new Composite("Comp2");
      const composite3 = new Composite("Comp3");

      composite1.add(leaf1);
      composite2.add(leaf2);
      composite3.add(leaf3);

      composite1.operation();
      composite2.operation();
      composite3.operation();

      composite2.add(composite3);
      composite1.add(composite2);
      composite1.operation();
   }
}
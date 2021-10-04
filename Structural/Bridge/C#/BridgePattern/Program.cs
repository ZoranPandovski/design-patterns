using System;
using BridgePattern.Monsters;
using BridgePattern.Mutators;

namespace BridgePattern
{
    // Bridge Pattern Definition: The Bridge pattern is meant to "decouple an abstraction from its implementation so the two can vary independently". To elaborate, it replaces complexity multiplication with
    // complexity addition.

    // Scenario:
    //    Suppose you have a Base Class, BaseMonster, and two subclasses - RegularMonster and UniqueMonster.
    //    Now, suppose that monsters can be modified by certain mutators - such as having a Flame Aura or randomly Teleporting.
    //    A Naive approach would be to create Four Subclasses, FlameAuraRegularMonster, TeleportationRegularMonster, FlameAuraUniqueMonster, and TeleportationUniqueMonster. This gives us a total of 6 classes. 
    //    If we want to combine mutators this gives us even more combinations (8 classes with the above combinations), so it leads us to exponential growth of the number of classes we have to implement.

    //    A Bridge pattern would be as follows:
    //    Implement a Mutator class and create 3 child classes, NoMutator, FlameAuraMutator and TeleportationMutator. Now, a RegularMonster and a UniqueMonster is each modified to take in an array of mutators to have applied
    //    to them. This reduces our classes from 6 down to 5, but if we want combinations it still leaves us with 5 classes versus 8 above).

    //    The result of introducing the Mutator class is that we create a Bridge between the BaseMonster class and the Mutator class, and in doing so, reduce coupling by splitting a class hierarchy through composition.
    class Program
    {
        static void Main(string[] args)
        {
            var skeleton = new RegularMonster("Skeleton", 1, 10, new Mutator[] { new NoMutator("No mutator") });
            var goblin = new RegularMonster("Goblin", 2, 15, new Mutator[] { new AuraMutator("Frost Aura") });
            var helish = new UniqueMonster("Helish", 2, 25, new Mutator[] { new AuraMutator("Flame Aura"), new TeleportationMutator("Teleportation Mutator") });

            Console.WriteLine(skeleton.GetDescription());
            Console.WriteLine(goblin.GetDescription());
            Console.WriteLine(helish.GetDescription());

        }
    }
}

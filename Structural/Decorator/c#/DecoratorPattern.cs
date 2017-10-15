using System;

namespace DecoratorPatternSample
{
    class DecoratorPattern     
    {
        /// <summary>
        /// Entry point into console application.
        /// </summary>
        static void Main()
        {
            // Create Pizza and two Decorators

            PlainTopping ordinaryPizza = new PlainTopping();
            ordinaryPizza.SetComponent(new Pizza());

            GrilledTomatoTopping myPizza = new GrilledTomatoTopping();
            myPizza.SetComponent(ordinaryPizza);

            myPizza.Operation();

            // Wait for user
            Console.ReadKey();
        }
    }

    /// <summary>
    /// The 'Component' abstract class
    /// </summary>
    abstract class Component
    {
        public abstract void Operation();
    }

    /// <summary>
    /// The 'Pizza' class
    /// </summary>
    class Pizza : Component
    {
        public override void Operation()
        {
            Console.WriteLine("Pizza.Operation()");
        }
    }

    /// <summary>
    /// The 'Topping' abstract class
    /// </summary>
    abstract class Topping : Component
    {
        protected Component component;

        public void SetComponent(Component component)
        {
            this.component = component;
        }

        public override void Operation()
        {
            if (component != null)
            {
                component.Operation();
            }
        }
    }

    /// <summary>
    /// The 'GrilledTomatoTopping' class
    /// </summary>
    class GrilledTomatoTopping : Topping
    {
        public override void Operation()
        {
            base.Operation();
            Console.WriteLine("GrilledTomatoTopping.Operation()");
        }
    }

    /// <summary>
    /// The 'PlainTopping' class
    /// </summary>
    class PlainTopping : Topping
    {
        public override void Operation()
        {
            base.Operation();
            AddedBehavior();
            Console.WriteLine("PlainTopping.Operation()");
        }

        void AddedBehavior()
        {
        }
    }
}
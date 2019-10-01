using System;

namespace TemplateMethod
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Starting...");

            BaseOrder order1 = new DerivedOrder1(1000);

            if (!order1.PlaceOrder())
            {
                Console.WriteLine("Failed placing the order...");
            }

            BaseOrder order2 = new DerivedOrder2(1000);

            if (!order2.PlaceOrder())
            {
                Console.WriteLine("Failed placing the order...");
            }
        }
    }
}

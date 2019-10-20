using csharp.Cars.Properties;
using csharp.Factory;
using System;

namespace csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Instantiate a CarFactory
            var carFactory = new CarFactory();

            // From the car factory, we can ask it to create new Cars.
            // We give a Type of car that we want and it will return us that car
            var corsa = carFactory.Create(Model.CORSA, Color.BLACK);
            var astra = carFactory.Create(Model.ASTRA, Color.GREY);

            for (int i = 0; i < 5; i++) // accelerate astra 5 times
                Console.WriteLine($"{astra.GetBrand()} {astra.GetModel()}: {astra.Accelerate()}");

            Console.WriteLine();

            for (int i = 0; i < 3; i++) // accelerate corsa 3 times
                Console.WriteLine($"{corsa.GetBrand()} {corsa.GetModel()}: {corsa.Accelerate()}");

            Console.WriteLine();
            Console.WriteLine($"{corsa.GetBrand()} {corsa.GetModel()}: {corsa.Break()}"); // corsa used breaks 1 time

            Console.WriteLine();
            Console.WriteLine($"{corsa.GetBrand()} {corsa.GetModel()} is going at {corsa.GetCurrentSpeed()}");
            Console.WriteLine($"{astra.GetBrand()} {astra.GetModel()} is going at {astra.GetCurrentSpeed()}");
        }
    }
}

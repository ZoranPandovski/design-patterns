using System;

namespace design_patterns
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hi! Creating vehicles through the Factory Method: ");

            VehicleFactory factory = new VehicleFactory();
            String name = "Ferrari 488";
            String via = "land";
            factory.GetVehicle(name, via);

            Console.WriteLine("Created {0}", factory.GetType().Name);
            
            Console.ReadKey();

        }
    }
}
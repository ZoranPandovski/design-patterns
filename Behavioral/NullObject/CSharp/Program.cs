using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NullObjectPattern
{
    class Program
    {
        static void Main(string[] args)
        {
            var ListOfVehicles = new List<Vehicle>();
            var car = new Car();
            car.SetEngine("CarEngine", 1499);
            ListOfVehicles.Add(car);

            var motorcycle = new Motorcycle();
            motorcycle.SetEngine("MotorcycleEngine", 125);
            ListOfVehicles.Add(motorcycle);

            var bicycle = new Bicycle();
            bicycle.SetEngine("Whatever", 123123);
            ListOfVehicles.Add(bicycle);

            foreach (var vehicle in ListOfVehicles)
            {
                vehicle.Start();
                Console.WriteLine(vehicle.Engine.ToString());
            }
        }
    }
}

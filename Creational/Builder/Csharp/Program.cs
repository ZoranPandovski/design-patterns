using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BuilderPattern
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Normal builder:");
            var car = new Car();
            car.SetColor("red");
            car.SetPower(125);
            Console.WriteLine(car);
            Console.WriteLine("------------");
            Console.WriteLine("Fluent builder:");
            var car2 = new Car().SetColorFluent("green").SetPowerFluent(200);
            Console.WriteLine(car2);
        }
    }
}

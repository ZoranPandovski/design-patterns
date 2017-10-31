using System;

namespace ObserverPattern
{
    class Program
    {
        static void Main(string[] args)
        {
            CarSubject car = new CarSubject();
            GarageObserver garage = new GarageObserver(car);

            //Just by executing this method, our garage will know the car color has changed
            car.SetColor(10);

            Console.ReadLine();
        }
    }
}

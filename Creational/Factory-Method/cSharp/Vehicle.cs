using System;

namespace design_patterns
{
    abstract class Vehicle
    {
        public String Brand { get; set; }
        public String Via { get; set; }

    }

    class Car : Vehicle
    {
        public Car(String brand)
        {
            this.Brand = brand;
            Console.WriteLine("The " + brand + " is a car.");
        }
    }
    class Boat : Vehicle
    {
        public Boat(String brand)
        {
            this.Brand = brand;
            Console.WriteLine("The " + brand + " is a boat.");
        }
    }
    class AirPlane : Vehicle
    {
        public AirPlane(String brand)
        {
            this.Brand = brand;
            Console.WriteLine("The " + brand + " is an airplane.");
        }
    }

    class VehicleFactory
    {
        public Vehicle GetVehicle(String brand, String via)
        {
            if (via.ToLower().Equals("air"))
                return new AirPlane(brand);
            if (via.ToLower().Equals("land"))
                return new Car(brand);
            if (via.ToLower().Equals("sea"))
                return new Boat(brand);

            throw new ArgumentException("Via unrecognized");
        }
    }
}

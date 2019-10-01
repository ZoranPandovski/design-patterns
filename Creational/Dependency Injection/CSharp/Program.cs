using System;

namespace DI
{

    interface IPowertrain
    {
        void Accelerate();
        void ApplyBrakes();
    }

    class GasolinePowered : IPowertrain
    {
        public void Accelerate()
        {
            Console.WriteLine("GasolinePowered: Accelerating.");
        }

        public void ApplyBrakes()
        {
            Console.WriteLine("GasolinePowered: Applying brakes.");
        }
    }

    class ElectricPowered : IPowertrain
    {
        public void Accelerate()
        {
            Console.WriteLine("ElectricPowered: Accelerating.");
        }

        public void ApplyBrakes()
        {
            Console.WriteLine("ElectricPowered: Applying Brakes.");
        }
    }

    abstract class PoweredVehicle
    {
        // This is where we inject our dependency
        // The Car class can use any implementation of IPowertrain
        // This makes it very flexible to change
        protected IPowertrain Powertrain;

        protected PoweredVehicle(IPowertrain powertrain)
        {
            this.Powertrain = powertrain;
        }

        public abstract void SteerLeft();
        public abstract void SteerRight();
        public abstract void Accelerate();
        public abstract void ApplyBrakes();
    }

    class Car : PoweredVehicle
    {
        public Car(IPowertrain powertrain) : base(powertrain)
        {
        }

        public override void SteerLeft()
        {
            Console.WriteLine("Car: Steering Left...");
        }

        public override void SteerRight()
        {
            Console.WriteLine("Car: Steering Right...");
        }

        public override void Accelerate()
        {
            Powertrain.Accelerate();
        }

        public override void ApplyBrakes()
        {
            Powertrain.ApplyBrakes();
        }
    }

    class DI_Example
    {
        static void Main(string[] args)
        {
            Car tesla = new Car(new ElectricPowered());
            tesla.Accelerate();
            tesla.ApplyBrakes();
            tesla.SteerLeft();
            tesla.SteerRight();

            Car ford = new Car(new GasolinePowered());
            ford.Accelerate();
            ford.ApplyBrakes();
            ford.SteerLeft();
            ford.SteerRight();
        }
    }
}
using csharp.Cars.Properties;
using csharp.Factory;

namespace csharp.Cars
{
    public abstract class Opel : Car
    {
        private int TopSpeed;
        private int CurrentSpeed;
        private int SpeedVariation;
        private Color Color { get; }
        private string Brand { get; }

        public Opel(Color color, int topSpeed, int speedVariation)
        {
            this.TopSpeed = topSpeed;
            this.CurrentSpeed = 0;
            SpeedVariation = speedVariation;
            Brand = this.GetType().BaseType.Name;
            Color = color;
        }

        public string Accelerate()
        {
            if (CurrentSpeed >= TopSpeed)
                return $"Going full speed at {CurrentSpeed}";

            CurrentSpeed += SpeedVariation;
            return $"Accelerating. Going at {CurrentSpeed}";
        }

        public string Break()
        {
            if (CurrentSpeed <= 0)
                return "Stopped";

            CurrentSpeed -= SpeedVariation;
            return $"Decreasing speed to {CurrentSpeed}";
        }

        public string GetBrand()
        {
            return Brand;
        }

        public string GetColor()
        {
            return Color.ToString();
        }

        public abstract string GetModel();

        public int GetCurrentSpeed()
        {
            return CurrentSpeed;
        }
    }
}

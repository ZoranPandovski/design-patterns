using System;

class MethodChaining
{
    public static void Main(string[] args)
    {
        var bigCircle = new Circle(123.2).IncrementRadius(21.3);
        var smallCircle = new Circle(5.5).DecrementRadius(4.1);

        Console.WriteLine($"The big circle (radius: {bigCircle.Radius} has an area of {bigCircle.Area}");
        Console.WriteLine($"The small circle (radius: {smallCircle.Radius} has a circumference of {smallCircle.Circumference}");
        Console.ReadLine();
    }

    class Circle
    {
        public double Radius;

        public double Area
        {
            get => Math.PI * Radius * Radius;
        }

        public double Circumference
        {
            get => 2 * Math.PI * Radius;
        }

        public Circle(double radius = 0.0)
        {
            Radius = radius;
        }

        public Circle SetRadius(double radius)
        {
            Radius = radius;
            return this;
        }

        public Circle IncrementRadius(double value)
        {
            Radius += value;
            return this;
        }

        public Circle DecrementRadius(double value)
        {
            Radius -= value;
            return this;
        }

    }
}
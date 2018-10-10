using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BuilderPattern
{
    public class Car
    {
        public string Color { get; set; }
        public int EnginePower { get; set; }

        public Car()
        {

        }

        public override string ToString()
        {
            return $"Car with {Color} color and {EnginePower} horse power";
        }
    }
    public static class Builder
    {
        public static void SetColor(this Car c, string colorName)
        {
            c.Color = colorName;
        }
        public static void SetPower(this Car c, int power)
        {
            c.EnginePower = power;
        }
    }
    public static class FluentBuilder
    {
        public static Car SetColorFluent(this Car c, string colorName)
        {
            c.Color = colorName;
            return c;
        }
        public static Car SetPowerFluent(this Car c, int power)
        {
            c.EnginePower = power;
            return c;
        }
    }
}

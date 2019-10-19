using csharp.Cars.Models;
using csharp.Cars.Properties;

namespace csharp.Factory
{
    public class CarFactory : AbstractFactory<Car>
    {
        public Car Create(Model model, Color color)
        {
            switch(model)
            {
                case Model.ASTRA:
                    return new Astra(color);
                default:
                    return new Corsa(color);
            }
        }
    }
}

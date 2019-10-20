using csharp.Cars.Properties;

namespace csharp.Factory
{
    public abstract class AbstractFactory<T>
    {
        // type T because the AbstractFactory doesn't need a type now but it will have to return the type when the interface is implemented
        public abstract T Create(Model model, Color color);
    }
}

using csharp.Cars.Properties;

namespace csharp.Factory
{
    public interface AbstractFactory<T>
    {
        T Create(Model model, Color color);
    }
}

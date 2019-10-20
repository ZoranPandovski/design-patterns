using csharp.Cars.Properties;

namespace csharp.Cars.Models
{
    public class Astra : Opel
    {
        private Model Model { get; }

        public Astra(Color color) : base(color, 260, 10)
        {
            Model = Model.ASTRA;
        }

        public override string GetModel()
        {
            return Model.ToString();
        }
    }
}

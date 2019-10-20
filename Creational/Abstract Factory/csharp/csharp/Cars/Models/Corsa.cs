using csharp.Cars.Properties;

namespace csharp.Cars.Models
{
    public class Corsa : Opel
    {
        private Model Model { get; }

        public Corsa(Color color) : base(color, 180, 5)
        {
            Model = Model.CORSA;
        }

        public override string GetModel()
        {
            return Model.ToString();
        }
    }
}

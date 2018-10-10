namespace NullObjectPattern
{
    public class Engine
    {
        public string Type { get; set; }
        public int Power { get; set; }

        public Engine(string type, int power)
        {
            Type = type;
            Power = power;
        }

        public override string ToString()
        {
            return Power == -1 ? "No engine here :(" : $"{Type} with power of: {Power}";
        }

        public static Engine NoEngine()
        {
            return new Engine("NoEngine", -1);
        }
    }
}
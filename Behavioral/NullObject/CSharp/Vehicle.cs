using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NullObjectPattern
{
    public abstract class Vehicle
    {
        public void Start()
        {
            Console.WriteLine($"{GetType().Name} Wruuuuum");
        }
        public Engine Engine { get; set; }

        public abstract void SetEngine(string name, int power);
    }
}

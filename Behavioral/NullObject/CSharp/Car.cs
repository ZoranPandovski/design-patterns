using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NullObjectPattern
{
    public class Car : Vehicle
    {
        public override void SetEngine(string name, int power)
        {
            Engine = new Engine(name, power);
        }
    }
}

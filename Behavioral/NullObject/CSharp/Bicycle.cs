using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NullObjectPattern
{
    public class Bicycle : Vehicle
    {
        public override void SetEngine(string name, int power)
        {
            Engine = Engine.NoEngine();
        }
    }
}

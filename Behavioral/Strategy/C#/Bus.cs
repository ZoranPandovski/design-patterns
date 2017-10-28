using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPattern
{
    class Bus : Strategy
    {
        public void Execute()
        {
            Console.WriteLine("Use the bus");
        }
    }
}

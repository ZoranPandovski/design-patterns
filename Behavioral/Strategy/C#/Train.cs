using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPattern
{
    class Train : Strategy
    {
        public void Execute()
        {
            Console.WriteLine("Use the train");
        }
    }
}

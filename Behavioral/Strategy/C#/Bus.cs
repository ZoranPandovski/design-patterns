using System;

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

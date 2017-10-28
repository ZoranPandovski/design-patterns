using System;

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

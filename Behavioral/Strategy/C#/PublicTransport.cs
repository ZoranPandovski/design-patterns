using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPattern
{
    class PublicTransport
    {
        public Strategy Strategy { get; set; }

        public PublicTransport(Strategy strategy)
        {
            this.Strategy = strategy;
        }

        public void ExecuteStrategy()
        {
            Strategy.Execute();
        }
    }
}

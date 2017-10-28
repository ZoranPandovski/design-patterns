using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPattern
{
    class Program
    {
        static void Main(string[] args)
        {
            PublicTransport publicTransport = new PublicTransport(new Train());
            publicTransport.ExecuteStrategy();
            
            //Now we can easily change this objects' strategy to another
            publicTransport.Strategy = new Bus();
            publicTransport.ExecuteStrategy();

            Console.ReadLine();
        }
    }
}

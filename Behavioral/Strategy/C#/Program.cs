using System;

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

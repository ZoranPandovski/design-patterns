using System;

namespace FacadePattern
{
    class Pizza : Food
    {
        public void Order()
        {
            Console.WriteLine("Ordering pizza...");
        }
    }
}

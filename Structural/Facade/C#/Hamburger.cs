using System;

namespace FacadePattern
{
    class Hamburger : Food
    {
        public void Order()
        {
            Console.WriteLine("Ordering a hamburger...");
        }
    }
}

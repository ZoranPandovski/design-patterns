using System;

namespace FacadePattern
{
    class Program
    {
        static void Main(string[] args)
        {
            Waiter waiter = new Waiter();

            waiter.OrderHamburger();
            waiter.OrderPizza();
            waiter.OrderSpaghetti();

            Console.ReadLine();
        }
    }
}

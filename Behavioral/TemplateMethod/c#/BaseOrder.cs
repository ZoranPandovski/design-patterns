using System;

namespace TemplateMethod
{
    public abstract class BaseOrder
    {
        private readonly decimal _basePrice;

        public BaseOrder(decimal basePrice)
        {
            _basePrice = basePrice;
        }

        public bool PlaceOrder()
        {
            PrintBeforeOrder();

            if (!ConfirmOrder(_basePrice))
            {
                return false;
            }

            PrintAfterOrder();

            return true;
        }

        private void PrintBeforeOrder()
        {
            Console.WriteLine("Initializing the order...");
        }

        private void PrintAfterOrder()
        {
            Console.WriteLine("Finishing the order...");
        }

        protected abstract bool ConfirmOrder(decimal price);
    }
}



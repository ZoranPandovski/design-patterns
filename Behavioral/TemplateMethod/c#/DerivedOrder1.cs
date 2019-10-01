namespace TemplateMethod
{
    public class DerivedOrder1 : BaseOrder
    {
        public DerivedOrder1(decimal basePrice) : base(basePrice)
        {

        }

        protected override bool ConfirmOrder(decimal price)
        {
            if (price > 0 && price < 10000)
            {
                return true;
            }
            return false;
        }
    }
}

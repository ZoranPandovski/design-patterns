namespace TemplateMethod
{
    public class DerivedOrder2 : BaseOrder
    {
        public DerivedOrder2(decimal basePrice) : base(basePrice)
        {

        }

        protected override bool ConfirmOrder(decimal price)
        {
            if (price >= 0 && price < 999)
            {
                return true;
            }
            return false;
        }
    }
}

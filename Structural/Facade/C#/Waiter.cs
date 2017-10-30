namespace FacadePattern
{
    class Waiter
    {
        private Food pizza;
        private Food spaghetti;
        private Food hamburger;

        public Waiter()
        {
            pizza = new Pizza();
            spaghetti = new Spaghetti();
            hamburger = new Hamburger();
        }

        public void OrderPizza()
        {
            pizza.Order();
        }

        public void OrderSpaghetti()
        {
            spaghetti.Order();
        }

        public void OrderHamburger()
        {
            hamburger.Order();
        }
    }
}

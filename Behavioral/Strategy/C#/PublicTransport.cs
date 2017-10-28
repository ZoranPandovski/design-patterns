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

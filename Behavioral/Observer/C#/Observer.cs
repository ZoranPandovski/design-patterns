namespace ObserverPattern
{
    abstract class Observer
    {
        protected Subject subject;
        public abstract void Update();
    }
}

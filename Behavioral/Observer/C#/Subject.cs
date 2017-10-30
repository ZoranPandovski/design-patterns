using System.Collections.Generic;

namespace ObserverPattern
{
    abstract class Subject
    {
        private List<Observer> observers;

        public Subject()
        {
            observers = new List<Observer>();
        }

        public void AddObserver(Observer observer)
        {
            observers.Add(observer);
        }

        public void RemoveObserver(Observer observer)
        {
            observers.Remove(observer);
        }

        public void NotifyObservers()
        {
            foreach(Observer o in observers)
            {
                o.Update();
            }
        }
    }
}

using System;

namespace ObserverPattern
{
    class GarageObserver : Observer
    {
        public GarageObserver(Subject subjectToObserve)
        {
            subject = subjectToObserve;
            subject.AddObserver(this);
        }

        public override void Update()
        {
            Console.WriteLine("I now know that my car's color has been set to: " + ((CarSubject)subject).Color);
        }
    }
}
using System;
using System.Collections.Generic;

public interface IObserver
{
    void BroadcastUpdate(string message);
}

public class Observer : IObserver
{
    public void BroadcastUpdate(string message)
    {
        Console.WriteLine(message);
    }
}

// the observable
public class Subject
{
    List<IObserver> observers = new List<IObserver>();
    string _state;

    public void SetState(string state)
    {
        _state = state;

        foreach (IObserver ob in observers)
        {
            ob.BroadcastUpdate($"Subject's state was changed to {_state}");
        }
    }

    public void RegisterObserver(IObserver observer)
    {
        observers.Add(observer);
    }
}


class Program
{
    static void Main(string[] args)
    {
        Subject subject = new Subject();
        Observer concreteObserver = new Observer();

        subject.RegisterObserver(concreteObserver);

        subject.SetState("001");
        subject.SetState("002");

        Console.ReadKey();
    }
}

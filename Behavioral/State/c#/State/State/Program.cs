using System;

namespace State
{
    public class Switch
    {
        public State state = new OffState();
        public void On()
        {
            state.On(this);
        }
        public void Off()
        {
            state.Off(this);
        }
    }

    public abstract class State
    {
        public virtual void On(Switch sw)
        {
            Console.WriteLine("The light is already on!");
        }

        public virtual void Off(Switch sw)
        {
            Console.WriteLine("The light is already off!");
        }
    }

    public class OnState : State
    {
        public OnState()
        {
            Console.WriteLine("Light turned on!");
        }
        public override void Off(Switch sw)
        {
            Console.WriteLine("Turning light off!");
            sw.state = new OffState();
        }
    }

    public class OffState : State
    {
        public OffState()
        {
            Console.WriteLine("Light turned off!");
        }

        public override void On(Switch sw)
        {
            Console.WriteLine("Turning light on!");
            sw.state = new OnState();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var ls = new Switch();
            ls.On();
            ls.Off();
            ls.Off();
        }
    }
}

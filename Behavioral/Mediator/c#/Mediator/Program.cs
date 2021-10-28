using System;
using System.Collections.Generic;
using System.Linq;

namespace Mediator
{
    public class Person
    {
        public string Name { get; set; }
        public ChatRoom Room;
        private List<string> chatLog = new List<string>();

        public Person(string name)
        {
            Name = name;
        }

        public void Say(string message)
        {
            Room.Broadcast(Name, message);
        }

        public void PrivateMessage(string who, string message)
        {
            Room.Message(Name, who, message);
        }

        public void Receive(string sender, string message)
        {
            string s = $"{sender}: '{message}'";
            chatLog.Add(s);
            Console.WriteLine($"[{Name}'s chat session] {s}");
        }
    }

    public class ChatRoom
    {
        private List<Person> people = new List<Person>();

        public void Join(Person p)
        {
            p.Room = this;
            people.Add(p);
            string joinMsg = $"{p.Name} joins the chat";
            Broadcast("room", joinMsg);
        }

        public void Broadcast(string source, string message)
        {
            foreach (var p in people)
            {
                if (p.Name != source)
                    p.Receive(source, message);
            }
        }

        public void Message(string source, string destination, string message)
        {
            people.FirstOrDefault(p => p.Name == destination)
                ?.Receive(source, message);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            var room = new ChatRoom();
            var john = new Person("John");
            var jane = new Person("Jane");

            room.Join(john);
            room.Join(jane);

            john.Say("hi");

            jane.Say("oh, hey john");

            var simon = new Person("Simon");

            room.Join(simon);
            simon.Say("Hi everyone!");

            jane.PrivateMessage("Simon", "Glad you could join!");
        }
    }
}

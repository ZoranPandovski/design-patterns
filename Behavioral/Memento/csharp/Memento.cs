using System;
using System.Collections.Generic;

//Originator. The object which's state changes during runtime.
public class ActiveServer
{

    public void SetState(string name, string ip)
    {
        IP = ip;
        Name = name;
        Console.WriteLine($"Active server set to {ip} - {name}");
    }

    public void GetState()
    {
        Console.WriteLine($"Active server is {IP} - {Name}");
    }


    string IP { get; set; }
    string Name { get; set; }

    public Memento GetSnaphot()
    {
        return new Memento() { IP = this.IP, Name = this.Name };
    }

    public void Restore(Memento memento)
    {
        this.IP = memento.IP;
        this.Name = memento.Name;
        Console.WriteLine($"Active server restored to {IP} - {Name}");
    }
}

//Memento. The memory object.
public class Memento
{
    public string IP { get; set; }
    public string Name { get; set; }
}

//Caretaker. Stores memento objects.
public class ServerList
{
    List<Memento> list = new List<Memento>();

    public void Add(Memento memento)
    {
        list.Add(memento);
    }

    public Memento Get(int id)
    {
        return list[id];
    }
}



class Program
{
    static void Main(string[] args)
    {
        ServerList serverList = new ServerList();
        ActiveServer activeServer = new ActiveServer();

        activeServer.SetState("Sicilia", "66.77.88.999");

        serverList.Add(activeServer.GetSnaphot());

        activeServer.SetState("Ireland", "55.66.77.999");

        serverList.Add(activeServer.GetSnaphot());

        activeServer.Restore(serverList.Get(0));

        activeServer.Restore(serverList.Get(1));

        activeServer.SetState("Oregon", "88.99.77.999");

        serverList.Add(activeServer.GetSnaphot());

        activeServer.Restore(serverList.Get(1));

        activeServer.Restore(serverList.Get(2));

        Console.ReadKey();
    }
}

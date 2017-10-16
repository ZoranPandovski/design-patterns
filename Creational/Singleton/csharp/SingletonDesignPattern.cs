using System;

public class SingletonDesignPattern
{
    static void Main(String[] args)
    {
        Singleton singleton = Singleton.getSingletonInstance();

        singleton.printSingleton();
    }
}

class Singleton
{
    private static Singleton obj;

    private Singleton()
    {

    }

    public static Singleton getSingletonInstance()
    {
        if (obj == null)
        {
            obj = new Singleton();
            return obj;
        }
        else
        {
            return obj;
        }
    }

    public void printSingleton()
    {
        Console.WriteLine("Singleton Class");
    }
}

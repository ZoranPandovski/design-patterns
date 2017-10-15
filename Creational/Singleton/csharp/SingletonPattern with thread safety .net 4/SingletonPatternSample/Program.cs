using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SingletonPatternSample
{
    class Program
    {
        static void Main(string[] args)
        {
            Singleton s;
         
            //Invoking Singleton instance twice parallely in order to check how many times it calls Singleton constructor

            Parallel.Invoke(() => {s= Singleton.Instance; }, () => {s= Singleton.Instance; });
            Console.ReadLine();
        }
    }
    public sealed class Singleton
    {
        private static readonly Lazy<Singleton> lazy =
            new Lazy<Singleton>(() => new Singleton());

        public static Singleton Instance { get { return lazy.Value; } }

        private Singleton()
        {
            Console.WriteLine("Constructor called!");
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;

namespace Flightweight
{
    public class User
    {
        private List<string> strings = new List<string>();
        private int[] names;
        public User(string fullName)
        {
            names = fullName.Split(' ').Select(getOrAdd).ToArray();
            int getOrAdd(string name)
            {
                int index = strings.IndexOf(name);
                if (index != -1) return index;
                else
                {
                    strings.Add(name);
                    return strings.Count - 1;
                }
            }
        }

        public string FullName => string.Join(" ", names.Select(i => strings[i]));
    }


    class Program
    {
        static void Main(string[] args)
        {
            //construct with flyweight;
            var users = new List<User>();

            var names = Enumerable.Range(0, 100).Select(_ => RandomString());
            var surnames = Enumerable.Range(0, 100).Select(_ => RandomString());
            foreach (var name in names)
                foreach(var surname in surnames)
            {
                    users.Add(new User($"{name} {surname}"));
            }
            var fullName = users[1].FullName;
            Console.WriteLine(fullName);
            
        }

        private static string RandomString()
        {
            Random rand = new Random();
            return new string(Enumerable.Range(0, 10)
                .Select(i => (char)('a' + rand.Next(26)))
                .ToArray());
        }
    }
}

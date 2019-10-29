using System;
using System.Collections;

namespace DoFactory.GangOfFour.Iterator.RealWorld
{
    public class Item
    {
        public Item(string name)
        {
            Name = name;
        }

        public string Name { get; }
    }

    public interface ICollection
    {
        Iterator CreateIterator();
    }

    /// <summary>
    /// The 'ConcreteAggregate' class
    /// </summary>
    public class Collection : ICollection
    {
        private ArrayList _items = new ArrayList();

        public Iterator CreateIterator()
        {
            return new Iterator(this);
        }

        public int Count
        {
            get { return _items.Count; }
        }

        public object this[int index]
        {
            get { return _items[index]; }
            set { _items.Add(value); }
        }
    }

    /// <summary>
    /// Iterator abstraction
    /// </summary>
    public interface IIterator
    {
        Item First();
        Item Next();
        bool Finished { get; }
        Item CurrentItem { get; }
    }

    /// <summary>
    /// Iterator implementation
    /// </summary>
    public class Iterator : IIterator
    {
        private Collection _collection;
        private int _current = 0;

        public int Step { get; set; } = 1;

        public Iterator(Collection collection)
        {
            _collection = collection;
        }

        public Item First()
        {
            _current = 0;
            return _collection[_current] as Item;
        }

        public Item Next()
        {
            _current += Step;
            if (Finished)
                return null;
            else
                return _collection[_current] as Item;
        }

        public Item CurrentItem
        {
            get { return _collection[_current] as Item; }
        }

        public bool Finished
        {
            get { return _current >= _collection.Count; }
        }
    }

    public class IteratorApp
    {
        static void Main()
        {
            Collection collection = new Collection();
            collection[0] = new Item("Item 1"); 
            collection[1] = new Item("Item 2"); 
            collection[2] = new Item("Item 3"); 
            collection[3] = new Item("Item 4");

            Iterator iterator = collection.CreateIterator();
            for (Item item = iterator.First(); !iterator.Finished; item = iterator.Next())
                Console.WriteLine(item.Name);

            Console.ReadKey();
        }
    }
}
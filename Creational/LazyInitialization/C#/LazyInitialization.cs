using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace LazyLoading
{
    public class data
    {
        public static List<int> GetList1()
        {
            List<int> list1 = new List<int>();
            for (int i = 0; i <= 5000000; i++)
            {
                list1.Add(i);
            }
            return list1;
        }

        public static Lazy<List<int>> GetList3()
        {
            Lazy<List<int>> list3 = new Lazy<List<int>>();
            for (int i = 0; i <= 5000000; i++)
            {
                list3.Value.Add(i);
            }
            return list3;
        }
        public static void Main()
        {

            Stopwatch st = new Stopwatch();
            st.Start();
            var dobj = new data();
            List<int> list1 = data.GetList1();
            foreach (int i in list1)
            {
                //just executing the loop to check time duration
            }
            st.Stop();
            Console.WriteLine("List Time:" + st.Elapsed);
            st.Reset();


            Stopwatch st1 = new Stopwatch();
            st1.Start();
            dobj = new data();
            Lazy<List<int>> list3Lazy = data.GetList3();
            List<int> list3 = list3Lazy.Value;
            foreach (int i in list3)
            {
                //just executing the loop to check time duration
            }
            st1.Stop();
            Console.WriteLine("Lazy List Time:" + st1.Elapsed);
            st1.Reset();
        }
    }

}


// Output
// List Time:00:00:00.0873842 
// Lazy List Time:00:00:00.0953126
// Notice that lazy list time is high since it loads only when value is needed, whereas in List Time it loads when object created and called.
// Typical use cases
// 1. When you have an object that is expensive to create, and the program might not use it. 
// 2. When you have an object that is expensive to create, and you want to defer its creation until after other expensive operations have been completed. For example, assume that your program loads several object instances when it starts, but only some of them are required immediately. You can improve the startup performance of the program by deferring initialization of the objects that are not required until the required objects have been created.

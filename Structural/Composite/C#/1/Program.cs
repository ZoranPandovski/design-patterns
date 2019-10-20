using System;

namespace CompositePattern
{
    class Program
    {
        static void Main(string[] args)
        {
            //Create tree which is our group
            Tree tree = new Tree();

            //Create individual leaves;
            Leaf leaf1 = new Leaf();
            Leaf leaf2 = new Leaf();
            Leaf leaf3 = new Leaf();

            //Add leaves to tree which are our group elements
            tree.Elements.Add(leaf1);
            tree.Elements.Add(leaf2);
            tree.Elements.Add(leaf3);

            //One leaf falls from tree, method Fall is only executed for one leaf
            leaf1.Fall();
            
            //All leaves fall from tree, method Fall is executed for all leaves in the tree
            tree.Fall();

            Console.ReadLine();

        }
    }
}

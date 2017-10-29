using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompositePattern
{
    class Leaf : TreeComponent
    {
        private bool hasFallen;

        public void Fall()
        {
            if (hasFallen)
            {
                Console.WriteLine("Already fell from tree");
            }
            else
            {
                Console.WriteLine("Falling from tree...");
                hasFallen = true;
            }
        }
    }
}

using System.Collections.Generic;

namespace CompositePattern
{
    class Tree : TreeComponent
    {
        public List<TreeComponent> Elements { get; private set; }

        public Tree()
        {
            Elements = new List<TreeComponent>();
        }

        public void Fall()
        {
            foreach(TreeComponent c in Elements)
            {
                c.Fall();
            }
        }
    }
}

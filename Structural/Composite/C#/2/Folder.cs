using System.Collections.Generic;

namespace Composite
{
    public class Folder : IComponent
    {
        private string name;
        private List<IComponent> components;

        public Folder(string name)
        {
            this.name = name;
            components = new List<IComponent>();
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public int GetSize()
        {
            int size = 0;
            foreach (IComponent component in components)
            {
                if (component != null)
                    size += component.GetSize();

                // Another way to write it:
                // size += component?.GetSize() ?? 0;
            }
            return size;
        }

        public void Add(IComponent component)
        {
            components.Add(component);
        }

        public override string ToString()
        {
            string str = string.Format("{0}\n*******\n", name);
            foreach (IComponent component in components)
            {
                str += component.ToString() + "\n";
            }
            return str;
        }
    }
}

namespace Composite
{
    public class File : IComponent
    {
        private string name;
        private readonly string extension;
        private int size;

        public File(string name, string extension)
        {
            this.name = name;
            this.extension = extension;
            size = 0;
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public string Extansion
        {
            get { return extension; }
        }

        public int GetSize()
        {
            return size;
        }

        public override string ToString()
        {
            return string.Format("{0}.{1}", name, extension);
        }
    }
}

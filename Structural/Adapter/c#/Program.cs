namespace Adapter
{
    class Program
    {
        static void Main(string[] args)
        {
            var xmlConverter = new XmlConverter();
            var adapter = new XmlToJsonAdapter(xmlConverter);
            adapter.ConvertXmlToJson();
        }
    }
}

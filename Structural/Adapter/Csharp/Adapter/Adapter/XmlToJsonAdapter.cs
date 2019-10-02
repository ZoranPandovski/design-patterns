using System;
using System.Linq;

namespace Adapter
{

    public class XmlToJsonAdapter : IXmlToJson
    {
        private readonly XmlConverter _xmlConverter;

        public XmlToJsonAdapter(XmlConverter xmlConverter)
        {
            _xmlConverter = xmlConverter;
        }

        public void ConvertXmlToJson()
        {
            var manufacturers = _xmlConverter.GetXML()
                    .Element("Manufacturers")
                    .Elements("Manufacturer")
                    .Select(m => new Manufacturer
                    {
                        Country = m.Attribute("Country").Value,
                        Name = m.Attribute("Name").Value,
                        Year = Convert.ToInt32(m.Attribute("Year").Value)
                    });

            new JsonConverter(manufacturers)
                .ConvertToJson();
        }
    }
}

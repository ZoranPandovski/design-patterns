using System.Collections.Generic;

namespace Adapter
{
    public class ManufacturerDataProvider
    {
        public List<Manufacturer> GetData() =>
           new List<Manufacturer>
           {
            new Manufacturer { Country = "Italy", Name = "Alfa Romeo", Year = 2016 },
            new Manufacturer { Country = "UK", Name = "Aston Martin", Year = 2018 },
            new Manufacturer { Country = "USA", Name = "Dodge", Year = 2017 },
            new Manufacturer { Country = "Japan", Name = "Subaru", Year = 2016 },
            new Manufacturer { Country = "Germany", Name = "BMW", Year = 2015 },
            new Manufacturer { Country = "Brazil", Name = "Gurgel", Year = 1969 }
           };
    }
}

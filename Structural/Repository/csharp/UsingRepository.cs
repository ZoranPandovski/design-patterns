using Project.Repository.Entities;
using Project.Repository.Interface;
using System.Collections.Generic;

namespace Project.Repository
{
    public class UsingRepository
    {
        static void Main()
        {
            IDefaultRepository test = new ExampleRepository();

            int id = 1;
            test.Remove(id);

            ExampleEntitie obj = new ExampleEntitie { Id = 1, Description = "Example" };
            test.Insert(obj);

            List<ExampleEntitie> result = test.Get();

            ExampleEntitie entitie = test.Get(obj.Id);

            test.Update(obj);
        }
    }
}
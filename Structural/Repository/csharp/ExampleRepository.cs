using Project.Repository.Interface;
using Project.Repository.Entities;
using System.Collections.Generic;

namespace Project.Repository
{
    public class ExampleRepository : IDefaultRepository
    {
        public void Remove(int id)
        {
            //Remove Entitie T by Id
        }

        public void Insert(ExampleEntitie obj)
        {
            //Insert an object obj
        }

        public List<ExampleEntitie> Get()
        {
            //Get a list of an object T
            return new List<ExampleEntitie>();
        }

        public ExampleEntitie Get(int id)
        {
            //Get an object of a T type
            return new ExampleEntitie();
        }

        public void Update(ExampleEntitie obj)
        {
            //Update object obj
        }
    }
}
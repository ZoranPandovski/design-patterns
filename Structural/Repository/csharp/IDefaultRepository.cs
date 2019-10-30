using Project.Repository.Entities;
using System.Collections.Generic;

namespace Project.Repository.Interface
{
    public interface IDefaultRepository
    {
        public void Remove(int id);
        public void Insert(ExampleEntitie obj);
        public List<ExampleEntitie> Get();
        public ExampleEntitie Get(int id);
        public void Update(ExampleEntitie obj);
    }
}
using System;
using System.Collections.Generic;
using System.Text;
using DAO.Interfaces;

namespace DAO.Implementation
{
    class MonsterDAOImpl : MonsterDAO
    {
        private List<Monster> Monsters = new List<Monster>();

        public void DeleteMonsterByName(string name)
        {
            Monster monster = Monsters.Find(x => x.Name == name);
            Monsters.Remove(monster);
        }

        public List<Monster> GetAllMonsters()
        {
            return Monsters;
        }

        public Monster GetMonsterByName(string name)
        {
            Monster monster = Monsters.Find(x => x.Name == name);
            return monster;
        }

        public List<Monster> GetMonstersByLevel(int level)
        {
            List<Monster> monsters = Monsters.FindAll(x => x.Level == level);
            return monsters;
        }

        public void SaveMonster(Monster monster)
        {
            Monsters.Add(monster);
        }
    }
}

using System;
using System.Collections.Generic;
using DAO.Implementation;

namespace DAO
{
    class Program
    {
        static void Main(string[] args)
        {
            MonsterDAOImpl monsterDAO = new MonsterDAOImpl();

            List<Monster> monsters = new List<Monster>()
            {
               new Monster("Mummy", 8, 55, "A Decrepid old mummy"),
               new Monster("Goblin", 1, 15, "A sneaky and conniving goblin"),
               new Monster("Skeleton", 1, 10, "A stumbling skeleton"),
               new Monster("Lich", 9, 65, "An evil, undead Lich who wields great power"),
            };

            foreach(var monster in monsters)
            {
                monsterDAO.SaveMonster(monster);
            }

            var levelOneMonsters = monsterDAO.GetMonstersByLevel(1);

            foreach(var monster in levelOneMonsters)
            {
                Console.WriteLine("Monster Name: " + monster.Name + " Description: " + monster.Description);
            }
        }
    }
}

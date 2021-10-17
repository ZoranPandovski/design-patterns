using System;
using System.Collections.Generic;
using System.Text;

namespace DAO.Interfaces
{
    interface MonsterDAO
    {
        List<Monster> GetAllMonsters();
        List<Monster> GetMonstersByLevel(int level);
        Monster GetMonsterByName(string name);
        void SaveMonster(Monster monster);
        void DeleteMonsterByName(string name);

    }
}

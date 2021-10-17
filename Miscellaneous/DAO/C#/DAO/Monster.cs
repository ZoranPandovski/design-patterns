using System;
using System.Collections.Generic;
using System.Text;

namespace DAO
{
    class Monster
    {
        public string Name { get; private set; }
        public int Level { get; private set; }
        public int HitPoints { get; private set; }
        public string Description { get; private set; }

        public Monster() { }

        public Monster(string name, int level, int hitPoints, string description)
        {
            Name = name;
            Level = level;
            HitPoints = hitPoints;
            Description = description;
        }
    }
}

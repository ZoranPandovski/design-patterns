using System;
using System.Collections.Generic;
using System.Text;

namespace RulesEngine
{
    class Player
    {
        public string Name { get; }
        public int HitPoints { get; }

        public Player(string name, int hitPoints)
        {
            Name = name;
            HitPoints = hitPoints;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace RulesEngine.GameObjects
{
    enum MONSTER_TYPE
    {
        Aberration,
        Animal,
        Dragon,
        Ethereal,
        Mechanical,
        Undead
    }

    class MonsterCard : BaseCard
    {
        public int AttackPower { get; }
        public int DefensePower { get; }
        public MONSTER_TYPE MonsterType { get; }
        public string Description { get; }

        public MonsterCard(string name, int attackPower, int defensePower, MONSTER_TYPE monsterType, string description) : base(name, CARD_TYPE.Monster)
        {
            AttackPower = attackPower;
            DefensePower = defensePower;
            MonsterType = monsterType;
            Description = description;
        }

        public override void PlayCard()
        {
            Console.WriteLine("Monster Card Played: " + Name + " Attack Power: " + AttackPower + " Defense Power: " + DefensePower + "\n\tDescription: " + Description);
        }
    }
}

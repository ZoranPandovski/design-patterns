using System;
using RulesEngine.GameObjects;
using RulesEngine.Rules;

namespace RulesEngine
{
    class Program
    {
        static RulesEngine rulesEngine = new RulesEngine();

        static void Main(string[] args)
        {
            var mummy = new MonsterCard("Mummy", 4, 3, MONSTER_TYPE.Undead, "A decrepid old mummy is lingering here.");
            var mechanical_golem = new MonsterCard("Mechanical Golem", 5, 4, MONSTER_TYPE.Mechanical, "A mindless golem meanders around aimlessly.");

            var castle_walls = new ItemCard("Castle Walls", ITEM_TYPE.Fortification, "Ancient castle walls stand tall above the horizon");

            var player = new Player("Player 1", 30);

            rulesEngine.AddRule(new FortificationBoostLifeRule());
            rulesEngine.AddRule(new UndeadSpectralTouchRule());
            rulesEngine.AddRule(new MechanicalBlastShieldRule());

            PlayRound(mummy, player);
            PlayRound(mechanical_golem, player);
            PlayRound(castle_walls, player);
        }


        static void PlayRound(BaseCard card, Player player)
        {
            rulesEngine.RunRules(card, player);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;
using RulesEngine.Interfaces;
using RulesEngine.GameObjects;
using RulesEngine.CardUtilities;

namespace RulesEngine
{
    class RulesEngine
    {
        List<ICardRule> Rules = new List<ICardRule>();

        public RulesEngine() { }

        public void AddRule(ICardRule rule)
        {
            Rules.Add(rule);
        }

        public void RunRules(BaseCard card, Player player)
        {
            foreach(var rule in Rules)
            {
                CardContext ctx = new CardContext(card, player);

                if( rule.ShouldRun(ctx) )
                {
                    Console.WriteLine("Player HitPoints Before: " + ctx.Player.HitPoints);
                    Console.WriteLine("Playing Card Before Rule");
                    ctx.Card.PlayCard();

                    Console.WriteLine("\nRunning rule for card: " + ctx.Card.Name);
                    CardContext res = new CardContext();
                    rule.Evaluate(ctx, out res);
                    Console.WriteLine("\n\n-------------------------\n\n");
                    Console.WriteLine("Player HitPoints After: " + res.Player.HitPoints);
                    Console.WriteLine("Playing Card After Rule");
                    res.Card.PlayCard();
                    Console.WriteLine("\n\n-------------------------\n\n");
                }
            }
        }
    }
}

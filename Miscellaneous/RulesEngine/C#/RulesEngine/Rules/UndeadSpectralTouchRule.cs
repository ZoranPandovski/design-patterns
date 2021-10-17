using System;
using System.Collections.Generic;
using System.Text;
using RulesEngine.CardUtilities;
using RulesEngine.Interfaces;
using RulesEngine.GameObjects;

namespace RulesEngine.Rules
{
    class UndeadSpectralTouchRule : ICardRule
    {
        public void Evaluate(CardContext ctx, out CardContext res)
        {
            res = new CardContext();

            var mc = ((MonsterCard)ctx.Card);

            MonsterCard resMc = new MonsterCard(mc.Name, mc.AttackPower + 1, mc.DefensePower, mc.MonsterType, mc.Description);
            res.Card = resMc;
            res.Player = ctx.Player;
        }

        public bool ShouldRun(CardContext ctx)
        {
            return ctx.Card is MonsterCard { MonsterType: MONSTER_TYPE.Undead };
        }
    }
}

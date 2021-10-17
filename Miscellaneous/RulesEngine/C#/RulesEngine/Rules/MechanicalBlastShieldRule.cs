using System;
using System.Collections.Generic;
using System.Text;
using RulesEngine.CardUtilities;
using RulesEngine.Interfaces;
using RulesEngine.GameObjects;

namespace RulesEngine.Rules
{
    class MechanicalBlastShieldRule : ICardRule
    {
        public void Evaluate(CardContext ctx, out CardContext res)
        {
            res = new CardContext();

            MonsterCard mc = ctx.Card as MonsterCard;

            MonsterCard resMc = new MonsterCard(mc.Name, mc.AttackPower, mc.DefensePower + 2, mc.MonsterType, mc.Description);
            res.Card = resMc;
            res.Player = ctx.Player;
        }

        public bool ShouldRun(CardContext ctx)
        {
            return ctx.Card is MonsterCard { MonsterType: MONSTER_TYPE.Mechanical };
        }
    }
}

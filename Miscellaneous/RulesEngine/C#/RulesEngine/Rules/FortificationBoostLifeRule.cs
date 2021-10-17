using System;
using System.Collections.Generic;
using System.Text;
using RulesEngine.CardUtilities;
using RulesEngine.GameObjects;
using RulesEngine.Interfaces;

namespace RulesEngine.Rules
{
    class FortificationBoostLifeRule : ICardRule
    {
        public void Evaluate(CardContext ctx, out CardContext res)
        {
            res = new CardContext();

            var player = ctx.Player;
            ItemCard fort = ctx.Card as ItemCard;

            ItemCard ic = new ItemCard(fort.Name, fort.ItemType, fort.Description);
            var updatedPlayer = new Player(player.Name, player.HitPoints + 1);

            res.Card = ic;
            res.Player = updatedPlayer;
        }

        public bool ShouldRun(CardContext ctx)
        {
            return ctx.Card is ItemCard { ItemType: ITEM_TYPE.Fortification };
        }
    }
}

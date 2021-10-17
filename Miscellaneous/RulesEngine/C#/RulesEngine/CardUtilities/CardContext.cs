using System;
using System.Collections.Generic;
using System.Text;
using RulesEngine.GameObjects;

namespace RulesEngine.CardUtilities
{
    class CardContext
    {
        public CardContext() { }
        public CardContext(BaseCard card, Player player)
        {
            Card = card;
            Player = player;
        }

        public BaseCard Card { get; set; }
        public Player Player { get; set; }
    }
}

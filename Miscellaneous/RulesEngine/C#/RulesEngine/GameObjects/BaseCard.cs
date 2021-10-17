using System;
using System.Collections.Generic;
using System.Text;

namespace RulesEngine.GameObjects
{
    enum CARD_TYPE
    {
        Monster,
        Item
    }

    abstract class BaseCard
    {
        public string Name { get; }

        public CARD_TYPE CardType { get; }

        public BaseCard( string name, CARD_TYPE card_type )
        {
            Name = name;
            CardType = card_type;
        }

        public abstract void PlayCard();
    }
}

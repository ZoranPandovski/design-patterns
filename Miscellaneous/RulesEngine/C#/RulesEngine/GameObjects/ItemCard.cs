using System;
using System.Collections.Generic;
using System.Text;

namespace RulesEngine.GameObjects
{
    enum ITEM_TYPE
    {
        Trap,
        Potion,
        Ammo,
        Jewel,
        Rune,
        Fortification,
        Weapon,
        Armor,
        Bomb
    }

    class ItemCard : BaseCard
    {

        public ITEM_TYPE ItemType { get; }
        public string Description { get; }

        public ItemCard(string name, ITEM_TYPE itemType, string description ) : base(name, CARD_TYPE.Item)
        {
            ItemType = itemType;
            Description = description;
        }

        public override void PlayCard()
        {
            Console.WriteLine("Item Card Played: " + Name + " Description: " + Description);
        }
    }
}

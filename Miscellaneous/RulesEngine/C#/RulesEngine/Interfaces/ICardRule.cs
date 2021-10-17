using System;
using System.Collections.Generic;
using System.Text;
using RulesEngine.CardUtilities;

namespace RulesEngine.Interfaces
{
    interface ICardRule
    {
        void Evaluate(CardContext ctx, out CardContext res);
        bool ShouldRun(CardContext ctx);
    }
}

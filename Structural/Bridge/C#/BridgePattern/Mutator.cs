using System;
using System.Collections.Generic;
using System.Text;

namespace BridgePattern.Mutators
{
    public abstract class Mutator
    {
        public string Name { get; }

        protected Mutator(string name)
        {
            Name = name;
        }

        public abstract string GetDescription();
    }

    public class NoMutator : Mutator
    {
        public NoMutator(string name) : base(name)
        {

        }

        public override string GetDescription()
        {
            return "has no special characteristics";
        }
    }

    public class AuraMutator : Mutator
    {
        public AuraMutator(string name) : base(name)
        {
        }

        public override string GetDescription()
        {
            return "has a " + Name;
        }
    }

    public class TeleportationMutator : Mutator
    {
        public TeleportationMutator(string name) : base(name)
        {
        }

        public override string GetDescription()
        {
            return "randomly teleports";
        }
    }
}

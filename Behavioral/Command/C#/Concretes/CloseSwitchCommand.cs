namespace CommandPattern
{
    /* The Command for turning on the device - ConcreteCommand #1 */
    public class CloseSwitchCommand : ICommand
    {
        private ISwitchable _switchable;

        public CloseSwitchCommand(ISwitchable switchable)
        {
            _switchable = switchable;
        }

        public void Execute()
        {
            _switchable.PowerOn();
        }
    }
}

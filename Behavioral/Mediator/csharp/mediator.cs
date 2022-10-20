namespace DesignPattern
{
    public class Collegue
    {
        public string Name;
        public ChatRoom Room;
        private List<string> chatLog = new List<string>();

        public Collegue(string name)
        {
            Name = name;
        }

        public void Say(string message)
        {
            Room.Broadcast(this.Name, message);
        }

        public void PrivateMessage(string who, string message)
        {
            Room.Message(this.Name, who, message);
        }
        public void Receive(string sender, string message)
        {
            string s = $"{sender}: '{message}'";
            chatLog.Add(s);
            Console.WriteLine($"[{Name}'s chat session] {s}");
        }
    }

    public class ChatRoom
    {
        private List<Collegue> collegues = new List<Collegue>();
        public void Join(Collegue collegue)
        {
            string joinMsg = $"{collegue.Name} joins the chat";
            Broadcast("room", joinMsg);
            collegue.Room = this;
            collegues.Add(collegue);
        }

        public void Broadcast(string source, string message)
        {
            foreach (var item in collegues)
            {
                if (item.Name != source)
                {
                    item.Receive(source, message);
                }
            }
        }

        public void Message(string source, string destination, string message)
        {
            collegues.FirstOrDefault(c => c.Name == destination)?.Receive(source, message);
        }
    }

    public class Demo
    {
        static void Main(string[] args)
        {
            var room = new ChatRoom();
            var john = new Collegue("John");
            var jane = new Collegue("Jane");

            room.Join(john);
            room.Join(jane);

            john.Say("hi");
            jane.Say("oh, hey John");

            var simon = new Collegue("Simon");
            room.Join(simon);
            simon.Say("Hi Everyone!");
            jane.PrivateMessage("Simon", "glad you could join us!");
        }
    }
}

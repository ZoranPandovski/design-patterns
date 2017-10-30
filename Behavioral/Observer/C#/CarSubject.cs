namespace ObserverPattern
{
    class CarSubject : Subject
    {
        public int Color { private set; get; }

       /* Now whenever we execute this method NotifyObservers is called as well
        * meaning that every object that observes this object will know that it's state has changed
        * */
        public void SetColor(int color)
        {
            Color = color;
            NotifyObservers();
        }
    }
}

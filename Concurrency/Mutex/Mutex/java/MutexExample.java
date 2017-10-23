public class MutexExample { 
    public static void main(String[] args) {
        Mutex lock = new Mutex();

        // The bank can only be accessed by one theif at a time
        Bank bank = new Bank(100, lock);
        Theif theifA = new Theif("Alice");
        Theif theifB = new Theif("Bob");
        theifA.rob(bank);
        theifB.rob(bank);
        theifA.start();
        theifB.start();
    }
}
public class SingletonDesignPattern {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingletonInstance();
        singleton.printSingleton();
    }
}

class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getSingletonInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public void printSingleton() {
        System.out.println("Singleton Class");
    }
}

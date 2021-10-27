public class SingletonDesignPattern {
    private static class Singleton {
        private static Singleton INSTANCE;

        private Singleton() {
        }

        public static Singleton getSingletonInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
            return INSTANCE;
        }

        public void printSingleton() {
            System.out.println("Singleton Class");
        }
    }
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingletonInstance();
        singleton.printSingleton();
    }

}

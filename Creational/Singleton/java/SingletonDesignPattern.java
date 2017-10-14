public class SingletonDesignPattern {
    
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingletonInstance();
       
        singleton.printSingleton();
    }
}

class Singleton {

    private static Singleton obj;
    
    private Singleton() {
    }
    
    public static Singleton getSingletonInstance() {
        if( obj == null ) {
            obj = new Singleton();
            return obj;
        }    
        else
            return obj;
    }
    
    public void printSingleton() {
        System.out.println("Singleton Class");
    }
}

/**
 * Double Check Locking Technique Singleton
 * <p>
 * This class is to domonstrate the true lazy initialization
 * singleton class that cover:
 * - Thread safe
 * - Multicore pararel and multithread friendly
 * - Atomic process
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class DoubleCheckSingletonPattern {

    public static void main(String[] args) {
        SingletonService.getInstance().print();
    }
}

// final class is to protect class from to be extends (fragile class problem).
final class SingletonService {

    private static volatile DummyService instance;

    // to protect class from being new instance from outside of class
    private SingletonService() {
    }

    // singleton static method that use double check locking
    // method are unable to overide   
    public static final DummyService getInstance() {
        // Volatile: Access happens always on valid caches
        DummyService localRef = instance;
        if (localRef != null) return localRef;

        synchronized (DoubleCheckSingletonPattern.class) {
            localRef = instance;
            if (localRef == null) {
                // First initialize localRef
                localRef = new DummyService();
                // Now we have the guarantee that localRef contains a fully initialized instance
                instance = localRef;
            }
            return localRef;
        }
    }
}

// example for service class for instance in singleton class
class DummyService {
    public void print() {
        System.out.println("Print something!");
    }
}

/**
 * The easier way to create a thread-safe singleton class is to make the global access method synchronized,
 * so that only one thread can execute this method at a time.
 * In this approach, the synchronized block is used inside the if condition with an additional check
 * to ensure that only one instance of a singleton class is created.
 * The following code snippet provides the double-checked locking implementation.
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}
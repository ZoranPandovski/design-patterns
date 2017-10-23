public class Mutex {
    private Object owner;

    public synchronized void acquire() throws InterruptedException {
        while (owner != null) {
            wait();
        }
        owner = Thread.currentThread();
    }
    public synchronized void release() {
        if (Thread.currentThread() == owner) {
            owner = null;
            notify();
        }
    }
}
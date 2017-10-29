/**
 * Guarded Suspension
 *      ref: <https://en.wikipedia.org/wiki/Guarded_suspension>
 */
public class GuardedSuspension {
    synchronized void guardedMethod() {
        while (!preCondition()) { // preCodition() is a method
            try {
                // Continue to wait
                wait();
                // …
            } catch (InterruptedException e) {
                // …
            }
        }
        // Actual task implementation
    }
    synchronized void alterObjectStateMethod() {
        // Change the object state
        // …
        // Inform waiting threads
        notify();
    }
}

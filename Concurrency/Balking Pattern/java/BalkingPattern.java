/**
 * Balking Pattern
 *      ref: <https://en.wikipedia.org/wiki/Balking_pattern>
 */
public class BalkingPattern {
    private boolean jobInProgress = false;

    public void job() {
        synchronized(this) {
           if (jobInProgress) {
               return;
           }
           jobInProgress = true;
        }
        // Code to execute job goes here
        // ...
    }

    void jobCompleted() {
        synchronized(this) {
            jobInProgress = false;
        }
    }
}

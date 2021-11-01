import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Thread Pool
 * ref: <https://en.wikipedia.org/wiki/Thread_pool>
 */
public class ThreadPool {
    private final BlockingQueue<Runnable> jobs;

    /**
     * Create a new thread pool. {@link ThreadPool#schedule(java.lang.Runnable)} to add a new job.
     * @param poolSize how many concurrent threads will be scheduled
     */
    public ThreadPool(int poolSize) {
        jobs = new LinkedBlockingQueue<>();
        for (int i = 0; i < poolSize; i++) {
            PoolWorker worker = new PoolWorker(this);
            worker.start();
        }
    }

    /**
     * Add a job to the pool to be executed.
     * If there are fewer jobs than active threads, a worker will take the job and run it immediately.
     * otherwise, it will stay in the FIFO queue until a worker/thread is available.
     * @param toRun the job to be scheduled
     */
    public void schedule(Runnable toRun) {
        jobs.add(toRun);
    }

    /**
     * Takes the oldest job waiting to be executed. Will block if there are no jobs.
     * @return a job to be executed
     * @throws InterruptedException if interrupted while waiting
     */
    synchronized private Runnable takeJob() throws InterruptedException {
        return jobs.take();
    }

    /**
     * Each worker/thread created by the thread pool.
     * They loop forever trying to take new jobs, blocking whenever there are no new jobs
     */
    private static class PoolWorker extends Thread {
        private final ThreadPool pool;

        public PoolWorker(ThreadPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    pool.takeJob().run();
                } catch (InterruptedException e) {
                    // Ignore the job if it was interrupted
                }
            }
        }
    }

    /**
     * Create a thread pool of only 3 threads, and 10 dummy {@link ThreadPool#test(int)()}.
     *
     * The outcome is that it immediately returns control, and schedules three jobs at a time.
     * As soon as one of those 3 jobs finishes, a new one is executed.
     * No new threads are created.
     *
     * @param args (not used)
     */
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3);
        for (int i = 0; i < 10; i++) {
            threadPool.schedule(test(i));
        }
        System.out.println("Done scheduling");
    }

    /**
     * Helper function to create dummy runnable that only wait for some time
     * @param index job index, used to print helpful tracking.
     * @return the job to be scheduled
     */
    public static Runnable test(int index) {
        return () -> {
            try {
                System.out.println(index + ") Start");
                Thread.sleep(1000);
                System.out.println(index + ") End");
            } catch (InterruptedException e) {
                // Do nothing
            }
        };
    }
}
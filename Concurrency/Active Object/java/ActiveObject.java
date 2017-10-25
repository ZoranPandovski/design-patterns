import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ActiveObject<T> {

    private final LinkedBlockingQueue<Callback<T>> queue;

    public ActiveObject() {
        // activation list
        queue = new LinkedBlockingQueue<>();

        // scheduler & servant
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        (new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        // scheduler: dispatch
                        Callback<T> req = queue.take();
                        Future<T> future = executorService.submit(req.getReq());

                        while (!future.isDone());

                        req.setDone(true);
                        try {
                            req.setRes(future.get());
                            req.setSuccess(true);
                        } catch (ExecutionException e) {
                            req.setSuccess(false);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        })).start();
    }

    public Callback<T> enqueue(Callable<T> request) throws InterruptedException {
        Callback<T> callback = new Callback<>(request);
        queue.put(callback);

        return callback;
    }

    static class Callback<K> {
        private final Callable<K> req;
        private K res;
        private volatile boolean isDone;
        private volatile boolean isSuccess;

        Callback(Callable<K> request) {
            this.req = request;
            isDone = false;
            isSuccess = false;
        }

        void setDone(boolean done) {
            isDone = done;
        }

        void setSuccess(boolean success) {
            isSuccess = success;
        }

        public boolean isDone() {
            return isDone;
        }

        public boolean isSuccess() {
            return isSuccess;
        }

        public Callable<K> getReq() {
            return req;
        }

        public K getRes() {
            return res;
        }

        public void setRes(K res) {
            this.res = res;
        }
    }
}

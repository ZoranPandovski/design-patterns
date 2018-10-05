package Semaphores.multiplex;

public class MultiplexThread extends Thread {

	public MultiplexThread() {
	}

	public void run() {
		//Before calling the method, the thread acquires the permit, after calling it, it releases it.
		Multiplex.semaphore.acquire();
		Multiplex.a();
		Multiplex.semaphore.release();
	}
}

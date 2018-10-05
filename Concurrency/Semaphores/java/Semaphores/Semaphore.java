package Semaphores;

/**
 * Although java.util.concurrent has its own semaphore class, this is a simpler implementation of a semaphore
 */
public class Semaphore {

	/**
	 * Semaphore's count, it represent how many threads can access the resource at the same time
	 */
	private int count;

	public Semaphore(int count) {
		this.count = count;
	}
	
	public synchronized void acquire() {
		count--;
		if(count < 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void release() {
		count++;
		if(count <= 0) {
			notify();
		}
	}

}

package Semaphores.mutex;

public class MutexThread extends Thread {

	private int times;

	private int type;

	public final static int TYPE_A = 1;

	public final static int TYPE_B = 0;


	public MutexThread(int veces, int llamar ) {
		this.times = veces;
		this.type = llamar;
	}

	public void run() {
		if(type == TYPE_A) {
			for(int i = 0; i < times; i++){
				Mutex.semaphore.acquire();
				Mutex.a();
				Mutex.semaphore.release();
			}
		}
		if(type == TYPE_B) {
			for(int i = 0; i < times; i++){
				Mutex.semaphore.acquire();
				Mutex.b();
				Mutex.semaphore.release();
			}
		}
	}

}

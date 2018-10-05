package Semaphores.signaling;

public class SignalingThread extends Thread {
	
	private int type;

	public final static int TYPE_A = 1;

	public final static int TYPE_B = 0;
	
	public SignalingThread(int tipo) {
		this.type = tipo;
	}
	
	public void run() {
		//As you always want a() to be called first, the thread that calls it releases the permit after calling a.
		if(type == TYPE_A) {
			Signaling.a();
			Signaling.semaphore.release();
		}
		if(type == TYPE_B) {
			Signaling.semaphore.acquire();
			Signaling.b();
		}
	}
}

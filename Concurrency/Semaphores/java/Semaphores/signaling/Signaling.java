package Semaphores.signaling;

import Semaphores.Semaphore;

/**
 * You can also use semaphores when you have a method that you always want to call before another.
 */
public class Signaling {
	
	public static double n;

	static Semaphore semaphore;
	
	public static void main(String[] args) {
		
		new Signaling();
		SignalingThread a = new SignalingThread(SignalingThread.TYPE_A);
		SignalingThread b = new SignalingThread(SignalingThread.TYPE_B);
		
		int orden = (int) (Math.random() * 100) % 2;

		if (orden == 0) {
			System.out.println("A starts");
			a.start();
			b.start();
		} else {
			System.out.println("B starts");
			b.start();
			a.start();
		}
		
	}
	
	public Signaling() {
		n = 0;
		semaphore = new Semaphore(0); //You want the first thread to call acquire() to block;
	}

	//In this case, you always want a to be called before b to avoid getting an exception.

	public static void a() {
		n = 2;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void b() {
		System.out.println(0 / n);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

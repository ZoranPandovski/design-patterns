package Semaphores.rendezVouz;

import Semaphores.Semaphore;

/**
 * You use semaphores this way when you want methods in different threads to happen in a certain order
 */
public class RendezVouz {

	/**
	 * In the end, n = ((3*8) + (4*7))/2 = 26
	 */
	private static int n;
	
	static Semaphore s1;
	
	static Semaphore s2;


	public static void main(String args[]) {
		new RendezVouz();
		RendezVouzThread a = new RendezVouzThread(RendezVouzThread.TYPE_A);
		RendezVouzThread b = new RendezVouzThread(RendezVouzThread.TYPE_B);

		int order = (int) (Math.random() * 100) % 2;
		if (order == 0) {
			System.out.println("B starts");
			a.start();
			b.start();
		} else {
			System.out.println("A starts");
			b.start();
			a.start();
		}
	}
	
	public RendezVouz() {
		n = 0;
		//In this case, semaphores start in 0, you want them to lock the first thread that calls acquire()
		s1 = new Semaphore(0);
		s2 = new Semaphore(0);
	}
	
	public static void xA() {
		n += 3*8;
	}
	
	public static void xB() {
		n += 4*7; 
	}
	
	public static void yA() {
		System.out.println(n);
	}
	
	public static void yB() {
		n = n/2;
	}
	
}

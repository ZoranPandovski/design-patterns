package Semaphores.multiplex;

import Semaphores.Semaphore;

public class Multiplex {
	
	static Semaphore semaphore;

	public static void main(String args[]) {
		new Multiplex();
		MultiplexThread[] threads = new MultiplexThread[50];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new MultiplexThread();
		}
		for(MultiplexThread thread : threads) {
			thread.start();
		}
	}
	
	public Multiplex() {
		//This semaphore ensures that a maximum of three threads are using the resource at the same time
		semaphore = new Semaphore(3);
	}

	/**
	 * You want to limit access to this method with the semaphore
	 */
	public static void a() {
		try {
			System.out.println("calling a");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

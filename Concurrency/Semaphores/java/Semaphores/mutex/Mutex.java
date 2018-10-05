package Semaphores.mutex;

import Semaphores.Semaphore;

public class Mutex {

    /**
     * This is the resource you want to limit access to
	 */
	private static int n; 
	
	static Semaphore semaphore;

	public static void main(String[] args) {
		
		new Mutex();
		MutexThread a = new MutexThread(10, MutexThread.TYPE_A);
		MutexThread b = new MutexThread(10, MutexThread.TYPE_B);

		//This starts the two threads randomly every time you run the program
		int order = (int) (Math.random() * 100) % 2;

		if (order == 0) {
			System.out.println("A starts");
			a.start();
			b.start();
		} else {
			System.out.println("B starts");
			b.start();
			a.start();
		}
	}
	
	public Mutex() {
		n = 0;
		semaphore = new Semaphore(1); //A mutex semaphore always has a count of 1
	}

	//Methods a and b operate the variable in different ways

	public static void a() {
		n += 1000;
		try {
			System.out.println(n);
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void b() {
		n ++;
		try {
			System.out.println(n);
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

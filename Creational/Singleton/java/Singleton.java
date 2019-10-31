
/**
 * An example of the <i>Singleton</i> design pattern.
 *
 * @author Joseph Cagle
 * @version 1.0, 10/31/19
 */

public class Singleton {
	
	/**
	 * A test {@code main} method.
	 */
	public static void main(String[] args) {
		Singleton objNumberOne = Singleton.getInstance(),
		          objNumberTwo = Singleton.getInstance();
		if (objNumberOne == objNumberTwo) System.out.println("the objects are ==");
	}
	
	/*
	 * The single instance of this class.
	 */
	private final static Singleton INSTANCE = new Singleton();
	private static boolean initialized = false;
	
	// We don't want anyone outside of this class getting an instance
	private Singleton() { }
	
	public static Singleton getInstance() {
		if (!initialized) {
			INSTANCE.initialize();
			initialized = true;
		}
		
		return INSTANCE;
	}
	
	private final void initialize() {
		// do stuff
		System.out.println("initializing");
	}

} // end class Singleton { }


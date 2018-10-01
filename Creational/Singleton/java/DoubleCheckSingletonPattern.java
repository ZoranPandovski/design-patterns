
/**
 * Double Check Locking Technique Singleton
 * 
 * This class is to domonstrate the true lazy initialization 
 * singleton class that cover:
 * - Thread safe
 * - Multicore pararel and multithread friendly
 * - Atomic process
 * 
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class DoubleCheckSingletonPattern {
	
		public static void main(String[] args) {        
        SingletonService.getInstance().print();                
    }	
}	
 
// final class is to protect class from to be extends (fragile class problem).
final class SingletonService {
    
    private static volatile DummyService instance;
    
    // to protect class from being new instance from outside of class
    private SingletonService() {        
    }
    
    // singleton static method that use double check locking
    // method are unable to overide   
    public static final DummyService getInstance() {
        if (instance != null) return instance;
        
        synchronized(DoubleCheckSingletonPattern.class) {
            if (instance == null) {
                instance = new DummyService();
            }
            return instance;
        }        
    }        
}

// example for service class for instance in singleton class
class DummyService {
    public void print(){
        System.out.println("Print something!");
    }
}

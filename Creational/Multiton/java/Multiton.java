import java.util.*;

public final class Multiton{

    /**
     * contains the created Multitons
     */
    private static final Map<Object, Multiton> MULTITONS = new HashMap<>();

    /**
     * This will return an instance of a Multiton.
     * If the Multiton doesn't already exist this will create a new Multiton.
     * This can be called at any time concurrently.
     *
     * @param key A unique key used to access the underlying Map
     * @return Multiton - a newly created or already existing one.
     */
    public static Multiton getInstance(Object key) {
        synchronized(MULTITONS){ //synchronize on the Multitons map
            Multiton multiton = MULTITONS.get(key);

            //lazy creation if no instance of the given key exists
            if(multiton == null){
                System.out.println("Create a new Multiton instance for key "+key);
                multiton = new Multiton();
                MULTITONS.put(key, multiton);
            }
            return multiton;
        }
    }

    private String input;

    /**
     * Private constructor used to build a new Multiton instance.
     */
    private Multiton(){
    }

    /**
     * Get the input
     * @return String - input
     */
    public String getInput(){
        return this.input;
    }

    /**
     * Set the input
     */
    public void setInput(String input){
        this.input = input;
    }

}
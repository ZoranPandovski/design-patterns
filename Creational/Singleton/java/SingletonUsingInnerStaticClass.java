/*
Bill Pugh created the Singleton class using an inner static helper class.
The private inner static class that contains the instance of the singleton class.
When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance method,
this class gets loaded and creates the Singleton class instance.
This is the most widely used approach for Singleton class as it doesn’t require synchronization.
Reflection can destroy this singleton implementation approache as well,
to overcome this situation with Reflection, Joshua Bloch suggests the use of Enum to implement Singleton design pattern.
 */
public class SingletonUsingInnerStaticClass {

    private SingletonUsingInnerStaticClass() {
    }

    //Inner static SingletonHelper class
    private static class SingletonUsingInnerStaticClassHelper {
        private static final SingletonUsingInnerStaticClass INSTANCE = new SingletonUsingInnerStaticClass();
    }

    public static SingletonUsingInnerStaticClass getInstance() {
        return SingletonUsingInnerStaticClassHelper.INSTANCE;
    }
}


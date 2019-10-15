public class SingletonLazyThreadSafe {
    int value;

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    private SingletonLazyThreadSafe() {
    }

    private static class InstanceHolder {
        private static final SingletonLazyThreadSafe INSTANCE = new SingletonLazyThreadSafe();
    }

    public static SingletonLazyThreadSafe getInstance() {
        return SingletonLazyThreadSafe.InstanceHolder.INSTANCE;
    }

}

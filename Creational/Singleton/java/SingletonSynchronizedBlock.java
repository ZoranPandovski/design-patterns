public class SingletonSynchronizedBlock {
    private static SingletonSynchronizedBlock instance;

    private SingletonSynchronizedBlock(){}

    public static SingletonSynchronizedBlock getInstance() {
        if(instance == null) {
            synchronized (SingletonSynchronizedBlock.class) {
                if(instance == null) {
                    instance = new SingletonSynchronizedBlock();
                }
            }
        }
        return instance;
    }
}

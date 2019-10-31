/**
 * Simple iterators methods which can iterate over generic data.
 *
 * @author ByWaleed
 * @version October 2019
 * */

public class IteratorGenerics  {

    public <T> void forLoop(T[] array) {
        for (int i = 0; i < array.length(); i++) {
            T val = array[i];
            System.out.println(val + " ");
        }
    }

    public <T> void forEachLoop(T[] array) {
        for (T val : array) {
            System.out.println(val + " ");
        }
    }

}

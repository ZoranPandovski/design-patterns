
/**
 * Created by trustgeek on 10/17/2017 {11:33 PM}.
 * Just like Adapter pattern, bridge design pattern is one of the Structural design pattern.
 * According to GoF bridge design pattern is:
 * Decouple an abstraction from its implementation so that the two can vary independently
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}
import org.junit.Assert;
import org.junit.Test;

public class MultitonTest {

    private final Object key_one = new Object();

    @Test
    public void testMultiton() {
        String key_two = "key_two";
        //Setup some Multitons with different keys
        this.fillMultiton(key_two);

        System.out.println("Test Multiton ...");

        //Test with first key
        Multiton multiton = Multiton.getInstance(key_one);
        //The input we get should be equal to "Multiton One!"
        Assert.assertEquals("Multiton One!", multiton.getInput());

        multiton.setInput("One Multiton!");

        //Check the second key
        multiton = Multiton.getInstance(key_two);
        //The input should be null, because we didn't set it yet
        Assert.assertNull(multiton.getInput());

        multiton.setInput("Multiton Two!");
        //Check the changed input
        Assert.assertEquals("Multiton Two!", multiton.getInput());

        //Check the third key
        multiton = Multiton.getInstance("key_three");
        Assert.assertEquals("Multiton Three!", multiton.getInput());
    }

    private void fillMultiton(String key_two){
        Multiton multiton = Multiton.getInstance(key_one);
        multiton.setInput("Multiton One!");

        Multiton.getInstance(key_two);

        multiton = Multiton.getInstance("key_three");
        multiton.setInput("Multiton Three!");
    }


}
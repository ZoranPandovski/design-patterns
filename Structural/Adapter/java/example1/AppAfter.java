import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class represent the need included of new Object external, the {@link Mobile}.
 * <br> 
 * The Mobile has other methods, it methods do not satisfy the default interface(({@link Device}))
 *     
 * */
public class AppAfter {

	public static void main(String[] args) {
		
		Device notebook = new Notebook();
		Device desktop = new Desktop();

		//Create a new MobileAdapter to be able to use existing implementations 
		Mobile mobile = new Mobile();
		Device mobileApadter = new MobileAdapter(mobile);
		
		List<Device> devices = new ArrayList<Device>();
		devices.add( notebook );
		devices.add( desktop );
		devices.add( mobileApadter );

		testFunctions(devices);
	}

	private static void testFunctions(List<Device> devices) {
		
		for (Device device : devices) {
			
			device.boot();
			device.reboot();
			device.shutdown();
			
			System.out.println("----------------------");
		}
	}

}

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class represent how it was before the need of Mobile
 * <br> 
 * 
 * The project has a interface {@link Device} and several routine using this interface,
 * see the method testFunctions()
 *     
 * */
public class AppBofere {

	public static void main(String[] args) {
		
		Device notebook = new Notebook();
		Device desktop = new Desktop();
		
		List<Device> devices = new ArrayList<Device>();
		devices.add( notebook );
		devices.add( desktop );

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

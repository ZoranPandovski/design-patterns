
public class ServiceLocatorPatternDemo {
	
	public static void main(String [] args) {
		
		Service service = new ServiceLocator().getService("Service1");
		service.execute();
		
		service = new ServiceLocator().getService("Service2");
		service.execute();
		
		service = new ServiceLocator().getService("Service1");
		service.execute();
		
		service = new ServiceLocator().getService("Service2");
		service.execute();
		
	}

}

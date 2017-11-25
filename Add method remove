import java.util.ArrayList;
import java.util.List;

public class Cache {
	
	private List<Service> services = new ArrayList<Service>();
	
	public Service getService(String serviceName){
		
		for(Service service:services){
			if(service.getName().equalsIgnoreCase(serviceName))
				return service;
		}
		return null;
	}
	public void addService(Service service) {
		services.add(service);
	}
	public void remove(Service service) {
		services.remove(service);
	}
}

public class ServiceLocator {

	private static Cache cache;
	
	static {
		cache = new Cache();
	}
	public static Service getService(String jndiName) {
		
		Service service =  cache.getService(jndiName);
		if(service != null)
		{
			System.out.println("returned object from cache");
			return service;
		}
		
		service = (Service) new InitialContext().lookup(jndiName);
		cache.addService(service);
		return service;
		
		service = (Service) new InitialContext().lookup(jndiName);
		cache.remove(service);
		return service;
	}
}

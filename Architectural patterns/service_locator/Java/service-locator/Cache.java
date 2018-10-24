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

}

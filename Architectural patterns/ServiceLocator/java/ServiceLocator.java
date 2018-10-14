
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
		
		
	}
}

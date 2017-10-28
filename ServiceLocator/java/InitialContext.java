
public class InitialContext {
	
	public Object lookup(String jndiName) {
		
		if("Service1".equalsIgnoreCase(jndiName)){
			return new Service1();
		}
		else if("Service2".equalsIgnoreCase(jndiName)) {
			return new Service2();
		}
		else {
			System.out.println("Jndi name "+jndiName+"   not configured please check logs");
			return null;
		}
	}

}

public class ToyotaFactory implements FactoryCar {

	public Minivan createMinivan() {
		
		return new Sienna();
	}

	public Pickup createPickup() {
		
		return new Tacoma();
	}

}

public class App{
    
	/**
	 * 
	 * Here is used a implementation Abstract Factory
	 * 
	 * */
	public static void main( String[] args ){
    
		FactoryCar factory;
		
		//Using firt implementations
		factory = new GMCFactory();
		printInformations(factory);
		
		//Using second implementation
		factory = new ToyotaFactory();
		printInformations(factory);
    }
	
	public static void printInformations(FactoryCar factory) {
		
		Minivan minivan = factory.createMinivan();
		System.out.println("------- Info MiniVan---------");
		minivan.printName();
		minivan.printFuel();
		System.out.println("-----------------------------");
		
		Pickup pickup = factory.createPickup();
		System.out.println("------- Info Pickup---------");
		pickup.printName();
		pickup.printFuel();
		System.out.println("-----------------------------");
	}
}

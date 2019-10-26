public class PrivateConstructor {
	private PrivateConstructor() {

		/*  
		 *  Classes that are not meant to be instantiated 
		 *  should have a private constructor to prevent 
		 *  accidental instantiation, some examples include:
		 *  
		 *  - a class that is a collection of static functions
		 *  - classes for which we want a more readable 
		 *    instantiation method (e.g. 
		 *    'ArrayList.createWithCapacity(5)')
		 *  - singletons
		*/
	}
}
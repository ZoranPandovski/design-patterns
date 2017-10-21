/**
 * Implements the invariant parts of the code
 * Has unimplemented abstract methods that the subclasses will implement
 * @author sherilpaulin
 *
 */
public abstract class Player {
	//invariant part
	public String getName(){
		return name;
	}
	//invariant part
	public String getNumber(){
		return number;
	}
	//customizable part
	public abstract String getMove();
}

/**
 * Implements the invariant parts of the code Has unimplemented abstract methods
 * that the subclasses will implement
 * 
 * @author sherilpaulin
 *
 */
public abstract class Player {

	protected String name;
	protected int number;

	public Player () {

	}

	public Player(String name, int number) {
		this.name = name;
		this.number = number;

	}

	protected String getName() {
		return name;
	}
	
	protected String getNumber() {
		return number;
	}

	// 1. Standardize the skeleton of an algorithm in a "template" method
	public void permormTrainingSession(){
		warmUp();
		heavyTraining();
		relaxMuscles();
	}

	// 2. Common implementations of individual steps are defined in base class
	private void warmUp(){
		System.out.println("Player " + this.name + " is warming up");
	}

	private void relaxMuscles(){
		System.out.println("Player " + this.name + " is relaxing muscles");
	}

	// 3. Steps requiring peculiar implementations are "placeholders" in the base class
	public abstract void heavyTraining();
}

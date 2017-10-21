/**
 * A goalkeeper is a player but has unique properties
 * @author sherilpaulin
 *
 */
public class Goalkeeper {
	private String name;
	private int number;
	public Goalkeeper(String name, int number){
		this.name = name;
		this.number = number;
	}

	@Override
	public String getMove(){
		return "Prevent Goals";
	}
	
}

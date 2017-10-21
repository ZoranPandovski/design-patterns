/**
 * A midfielder is a player but has unique properties
 * @author sherilpaulin
 *
 */
public class Midfielder {
	private String name;
	private int number;
	public Midfielder(String name, int number){
		this.name = name;
		this.number = number;
	}
	@Override
	public String getMove(){
		return "Create plays";
	}
	

}

/**
 * A defender is a player but has unique properties
 * @author sherilpaulin
 *
 */
public class Defender {
	private String name;
	private int number;
	
	public Defender(String name, int number){
		this.name = name;
		this.number = number;
		
	}
	@Override
	public String getMove(){
		return "Defend";
	}
	
}

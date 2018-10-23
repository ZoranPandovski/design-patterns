import java.util.List;

/**
 * same usage of this pattern
 * @author sherilpaulin
 *
 */
public class TemplateMethodDemo {
	public static void main(String[] args) {
		
		List<Player> players = new ArrayList<Player>();

		players.add(new Defender("Sergio Ramos", 4));
		players.add(new Midfielder("Luka Modric",10));
		players.add(new Goalkeeper("Keylor Navas", 1));

		players.stream().forEach(p -> p.permormTrainingSession());

	}
}

/**
 * same usage of this pattern
 * @author sherilpaulin
 *
 */
public class TemplateMethodDemo {
	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>;
		players.add(new Defender("Sergio Ramos", 4));
		players.add(new Midfielder("Luka Modric",10));
		players.add(new Goalkeeper("Keylor Navas", 1));
		for (Player player: players){
			System.out.println(String.format("%s #%d", player.getName(), player.getNumber()));
			System.out.println(player.getMove());
		}
	}
}

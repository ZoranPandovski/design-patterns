class House {
    private String houseWalls;
	private String houseFloor;
	private String houseCeiling;

	public void setHouseWalls(String walls) {
		houseWalls = walls;
		
	}

	public String getHouseWalls() {
		return houseWalls;
	}

	public void setHouseFloor(String floor) {
		houseFloor = floor;
	}

	public String getHouseFloor() {
		return houseFloor;
	}

	public void setHouseCeiling(String ceiling) {
		houseCeiling = ceiling;
	}
	
	public String getHouseCeiling() {
		return houseCeiling;
	}
	
}

interface HouseBuilder {
	
	public void buildHouseWalls();
	
	public void buildHouseFloor();
	
	public void buildHouseCeiling();
	
	public House getHouse();
}


class SomeHouseBuilder implements HouseBuilder{
	private House house;

	public SomeHouseBuilder() {
		this.house = new House();
	}
	
	@Override
	public void buildHouseWalls() {
		house.setHouseWalls("sky blue walls");
	}

	@Override
	public void buildHouseFloor() {
		house.setHouseFloor("Marble Flooring");
	}

	@Override
	public void buildHouseCeiling() {
		house.setHouseCeiling("Tray Ceiling");
	}
	
	
	public House getHouse() {
		return this.house;
	}
}

class HouseArchitect {
	private HouseBuilder houseBuilder;
	
	public HouseArchitect(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}
	
	public House getHouse() {
		return this.houseBuilder.getHouse();
	}
	
	public void makeHouse() {
		this.houseBuilder.buildHouseCeiling();
		this.houseBuilder.buildHouseFloor();
		this.houseBuilder.buildHouseWalls();
	}
}

public class HouseExample {
	public static void main(String[] args) {
		HouseBuilder someHouse = new SomeHouseBuilder();
		
		HouseArchitect houseArchitect = new HouseArchitect(someHouse);
		houseArchitect.makeHouse();
		
		House firstHouse = houseArchitect.getHouse();
		
		System.out.println("House walls type: "+firstHouse.getHouseWalls());
		System.out.println("House floor type: "+firstHouse.getHouseFloor());
		System.out.println("House ceiling type: "+firstHouse.getHouseCeiling());

	}
}
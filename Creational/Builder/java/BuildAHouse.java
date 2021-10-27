public class BuildAHouse {
  private static class House{
    private boolean hasWalls;
    private boolean hasRooms;
    private boolean hasDoors;
    private boolean hasKitchen;
    private boolean hasBathroom;

    //Only builder can create objects
    private House(){

    }

    private static class HouseBuilder{
      private boolean hasWalls;
      private boolean hasRooms;
      private boolean hasDoors;
      private boolean hasKitchen;
      private boolean hasBathroom;

      HouseBuilder buildWalls(){
        hasWalls = true;
        return this;
      }

      HouseBuilder buildRooms(){
        hasRooms = true;
        return this;
      }

      HouseBuilder buildDoors(){
        hasDoors = true;
        return this;
      }

      HouseBuilder buildKitchen(){
        hasKitchen = true;
        return this;
      }

      HouseBuilder buildBathroom(){
        hasBathroom = true;
        return this;
      }

      House build(){
        House house = new House();
        house.hasWalls = this.hasWalls;
        house.hasRooms = this.hasRooms;
        house.hasDoors = this.hasDoors;
        house.hasKitchen = this.hasKitchen;
        house.hasBathroom = this.hasBathroom;
        return house;
      }
    }

  }
  public static void main(String[] args) {
    House.HouseBuilder houseBuilder = new House.HouseBuilder();
    House houseWithoutBathroom = houseBuilder
                                  .buildDoors()
                                  .buildKitchen()
                                  .buildRooms()
                                  .buildWalls()
                                  .build();
  }

}

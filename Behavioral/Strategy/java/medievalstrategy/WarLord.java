package medievalstrategy;

public class WarLord {

  private WarStrategy strategy;

  public WarLord() {
  }

  public void setStrategy(WarStrategy strategy) {
    this.strategy = strategy;
  }

  public void besiegeTheCity() {
    System.out.println(" ►►►►►►► " + this.strategy.attack());
  }
}

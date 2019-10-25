package medievalstrategy.strategies;

import medievalstrategy.WarStrategy;

public class DestroyTheGate implements WarStrategy {
  @Override
  public String attack() {
    return "👑 Besiege the gate by destroying the gate";
  }
}

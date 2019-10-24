package medievalstrategy.strategies;

import medievalstrategy.WarStrategy;

public class UseTheSecretPassage implements WarStrategy {
  @Override
  public String attack() {
    return "👺 Besiege the gate by using the secret passage";
  }
}

package medievalstrategy;

import medievalstrategy.strategies.CallTheTanks;
import medievalstrategy.strategies.DestroyTheGate;
import medievalstrategy.strategies.UseTheSecretPassage;

/**
 * As a WarLord, you have to choose the appropriate strategy to besiege a city regarding your army key asset !
 */
public class MedievalStrategy {

  public static void main(String[] args) {

    var kratos = new WarLord();

  // for each key asset of your army we will choose the appropriate strategy and the WarLord will apply it.
    for(ArmyKeyAsset keyAsset : ArmyKeyAsset.values()) {
      System.out.println("🔥 My army key asset is: " + keyAsset.name() + " 💥");
      chooseStrategy(kratos, keyAsset);
      kratos.besiegeTheCity();
    }
  }

  private static void chooseStrategy(WarLord kratos, ArmyKeyAsset keyAsset) {
    switch (keyAsset) {
      case STRENGTH:
        kratos.setStrategy(new DestroyTheGate()); break;
      case FURTIVITY:
        kratos.setStrategy(new UseTheSecretPassage()); break;
      case NETWORKING:
        kratos.setStrategy(new CallTheTanks()); break;
      default:
        throw new RuntimeException("There is no strategy for other cases =( ");
    }
  }
}

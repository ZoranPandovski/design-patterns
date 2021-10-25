import java.util.Arrays;
import java.util.List;

/**
 * Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass
 * but lets subclasses override specific steps of the algorithm without changing its structure.
 *
 * Here StorageSource is the superclass defining the template algorithm that subclasses define specific steps for
 *
 * author: Ruchika8
 * Refer - https://refactoring.guru/design-patterns/template-method
 */
public class TemplateMethod {
  public static void main(String[] args) {
    List<StorageSource> storageSourceList = Arrays.asList(new Platform("ACP"),new SharedCloud("SC") );
    storageSourceList.stream().forEach(x->x.describeStorage());

    /**
     * ----------------output-----------------------
     * This is the cloud ACP.Its performance is quite sluggish.
     * This is the cloud SC.Its performance is better by 50%.
     */
  }

  private abstract static class StorageSource{
    private String cloud;

    StorageSource(String cloud){
      this.cloud = cloud;
    }
    //----------------------------Protected Method------------------------------
    protected abstract String getPerformance();
    //---------------------------Template Method--------------------------------
    void describeStorage(){
      StringBuilder sb = new StringBuilder();
      sb.append("This is the cloud ").append(this.cloud).append(".").append(getPerformance());
      System.out.println(sb.toString());
    }
  }

  private static class Platform extends StorageSource{

    Platform(String cloud) {
      super(cloud);
    }

    @Override
    protected String getPerformance() {
      return "Its performance is quite sluggish.";
    }
  }

  private static class SharedCloud extends StorageSource{

    SharedCloud(String cloud) {
      super(cloud);
    }

    @Override
    protected String getPerformance() {
      return "Its performance is better by 50%.";
    }
  }
}

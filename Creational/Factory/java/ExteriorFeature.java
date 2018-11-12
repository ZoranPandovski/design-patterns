public class ExteriorFeature implements Feature {

  private String exteriorFeature;

  ExteriorFeature() {
    exteriorFeature = "Generic";
  }

  ExteriorFeature(String exteriorFeature) {
    this.exteriorFeature = exteriorFeature;
  }

  public String getFeature() {
    return exteriorFeature;
  }

  public void setFeature(String exteriorFeature) {
    this.exteriorFeature = exteriorFeature;
  }

  public String toString (){
    return "Exterior [" + exteriorFeature + "]" + "\n";
  }

}

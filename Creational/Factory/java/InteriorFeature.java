public class InteriorFeature implements Feature {

  private String interiorFeature;

  InteriorFeature() {
    interiorFeature = "Generic";
  }

  InteriorFeature(String interiorFeature) {
    this.interiorFeature = interiorFeature;
  }

  public String getFeature() {
    return interiorFeature;
  }

  public void setFeature(String interiorFeature) {
    this.interiorFeature = interiorFeature;
  }

  @Override
  public String toString() {
    return "Interior [" + interiorFeature + "]" + "\n";
  }

}

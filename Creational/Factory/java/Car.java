import java.util.Date;

public class Car extends Vehicle {

  private Feature[] feature = new Feature[10];
  private int carAxle;

  Car(){
    super();
    Feature[] f = {new InteriorFeature("No Interior Features"),
        new ExteriorFeature("No Exterior Features")};
    feature = f;
    carAxle = 2;
  }

  public Car(Date vehicleManufacturedDate, String vehicleManufacturer,
      String vehicleMake, String vehicleModel, Chassis vehicleFrame, String vehicleType,
      String driveTrain, Engine vehicleEngine, Feature[] feature, int carAxle) {
    super(vehicleManufacturedDate, vehicleManufacturer, vehicleMake, vehicleModel, vehicleFrame,
        vehicleType, driveTrain, vehicleEngine);
    this.feature = feature;
    this.carAxle = carAxle;
  }

  public String getExteriorFeatures() {
    String list = "";
    for (int i = 0; i < feature.length; i++) {
      if (feature[i] instanceof ExteriorFeature) {
        if (list.length() == 0) {
          list += this.feature[i];
        } else {
          list += "\n\t" + " : Exterior [" + feature[i] + "]";
        }
      }
    }
    return list;
  }

  public String getInteriorFeatures() {
    String list = "";
    for (int i = 0; i < feature.length; i++) {
      if (feature[i] instanceof InteriorFeature) {
        if (list.length() == 0) {
          list += this.feature[i];
        } else {
          list += "\n\t" + " : Interior [" + feature[i] + "]";
        }
      }
    }
    return list;
  }

  public String toString() {
    String list = "";
    for (int i = 0; i < feature.length; i++) {
      if (list.length() == 0) {
        list += feature[i];
      } else {
        list += "\n\t" + feature[i];
      }
    }
    return super.toString() + "\n" +
        "Features\t : " + list + "\n" +
        "Car axle\t : " + carAxle;
  }
}

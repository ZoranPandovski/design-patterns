public class VehicleFrame implements Chassis {

  private String vehicleFrameType;

  public VehicleFrame() {
    this.vehicleFrameType = "Unibody";
  }

  public VehicleFrame(String vehicleFrameType) {
    this.vehicleFrameType = vehicleFrameType;
  }

  @Override
  public Chassis getChassisType() {
    return this;
  }

  @Override
  public void settChassisType(String vehicleFrameType) {
    this.vehicleFrameType = vehicleFrameType;
  }

  public String toString() {
    return "Chassis: " + chassis + "\n" +
        "Vehicle Frame: " + vehicleFrameType +"\n";
  }
}

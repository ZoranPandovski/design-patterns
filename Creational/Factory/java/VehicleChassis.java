public class VehicleChassis implements Chassis {

  private String chassisName;

  public VehicleChassis() {
    this.chassisName = chassis;
  }

  public VehicleChassis(String chassisName) {
    this.chassisName = chassisName;
  }

  @Override
  public Chassis getChassisType() {
    return this;
  }

  @Override
  public void settChassisType(String vehicleChassis) {
    chassisName = vehicleChassis;
  }

  public String toString() {
    return "Chassis Name : Chassis";
  }
}

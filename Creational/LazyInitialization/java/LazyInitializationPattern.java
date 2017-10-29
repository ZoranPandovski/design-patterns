public class LazyInitializationPattern {
    public static void main(String[] args) {
        Vehicle.getVehicleByTypeName(VehicleType.car);
        Vehicle.showAll();
        Vehicle.getVehicleByTypeName(VehicleType.bus);
        Vehicle.showAll();
        Vehicle.getVehicleByTypeName(VehicleType.car);
        Vehicle.showAll();
    }
}


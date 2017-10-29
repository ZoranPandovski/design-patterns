import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

enum VehicleType{
    none,
    car,
    bus,
}

class Vehicle{

    private static Map<VehicleType, Vehicle> types = new HashMap<>();
    private Vehicle(VehicleType type) {
    }
    public static Vehicle getVehicleByTypeName(VehicleType type) {
        Vehicle vehicle;
        if (!types.containsKey(type)) {
            // Lazy initialisation
            vehicle = new Vehicle(type);
            types.put(type, vehicle);
        } else {
            vehicle = types.get(type);
        }
        
        return vehicle;
    }
    
    public static void showAll() {
        if (types.size() > 0) {
           System.out.println("Number of instances made = " + types.size());
            for (Entry<VehicleType, Vehicle> entry : types.entrySet()) {
                String vehicle = entry.getKey().toString();
                vehicle = Character.toUpperCase(vehicle.charAt(0)) + vehicle.substring(1);
                System.out.println(vehicle);
            }
            
            System.out.println();
        }
    }
}

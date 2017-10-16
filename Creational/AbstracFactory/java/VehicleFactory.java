public class VehicleFactory {

    public static Vehicle getVehicle(int option){
        Vehicle vehicle = null;
        if( option == 1) vehicle =  new Car();
        else if ( option == 2) vehicle = new Airplane();
        else if ( option == 3) vehicle =  new Bicycle();
        return vehicle;
    }
}

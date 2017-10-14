import java.util.Scanner;

class Car implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}
class Airplane implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Flying an airplane");
    }
}
class Bicycle implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Riding a bicycle");
    }
}
public class FatoryPattern {
    public static void main(String[] args){
        Vehicle vehicle = null;
        System.out.println("Vehicle Factory");
        System.out.println("Please select your vehicle");
        System.out.println("[1] Car");
        System.out.println("[2] Airplane");
        System.out.println("[3] Bicycle");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        vehicle = VehicleFactory.getVehicle(option);
        System.out.print("Drive a vehicle : ");
        vehicle.drive();
    }
}

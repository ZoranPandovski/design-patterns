abstract class Vehicle {

    public abstract String getTire();

    public abstract String getGlass();

    public abstract String getGearBox();

    public abstract String getSeet();

    public abstract String getBody();

    public abstract String getLight();

    @Override
    public String toString() {
        return "Tire= " + this.getTire() + ", Glasses=" + this.getGlass() + ", GearSet=" + this.getGearBox() + ", Seet=" + this.getSeet() + ", Body=" + this.getBody() + ", Lights=" + this.getLight();
    }
}

class Van extends Vehicle {

    private String tire;
    private String glasses;
    private String gearSet;
    private String seet;
    private String body;
    private String lights;

    Van(String tire, String glasses, String gearSet, String seet, String body, String lights) {
        this.tire = tire;
        this.glasses = glasses;
        this.gearSet = gearSet;
        this.seet = seet;
        this.body = body;
        this.lights = lights;

    }

    public String getTire() {
        return this.tire;
    }

    public String getGlass() {
        return this.glasses;
    }

    public String getGearBox() {
        return this.gearSet;
    }

    public String getSeet() {
        return this.seet;
    }

    public String getBody() {
        return this.body;
    }

    public String getLight() {
        return this.lights;
    }

}

class Car extends Vehicle {

    private String tire;
    private String glasses;
    private String gearSet;
    private String seet;
    private String body;
    private String lights;

    Car(String tire, String glasses, String gearSet, String seet, String body, String lights) {
        this.tire = tire;
        this.glasses = glasses;
        this.gearSet = gearSet;
        this.seet = seet;
        this.body = body;
        this.lights = lights;

    }

    public String getTire() {
        return this.tire;
    }

    public String getGlass() {
        return this.glasses;
    }

    public String getGearBox() {
        return this.gearSet;
    }

    public String getSeet() {
        return this.seet;
    }

    public String getBody() {
        return this.body;
    }

    public String getLight() {
        return this.lights;
    }

}

class VehicleFactory {

    public static Vehicle getVehicle(String type, String tire, String glasses, String gearSet, String seet, String body, String lights) {
        if ("Car".equalsIgnoreCase(type)) {
            return new Car(tire, glasses, gearSet, seet, body, lights);
        } else if ("Van".equalsIgnoreCase(type)) {
            return new Van(tire, glasses, gearSet, seet, body, lights);
        }

        return null;
    }
}

public class TestFactory {

    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("Car", "Maxxis", "windshields ", "5 gear", "4 seet", "Hatchback", "6 lights");
        Vehicle van = VehicleFactory.getVehicle("Van", "Maxxis", "Impala", "4 gear", "5 seet", "Crossover", "8 lights");
        System.out.println("Factory car details::" + car);
        System.out.println("Factory van  details::" + van);
    }

}

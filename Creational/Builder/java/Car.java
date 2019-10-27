
public class Car {
    private String model;
    private String make;
    private String year;
    private String colour;
    private Boolean hasAircon = false;  // optional field

    private Car() {}

    public static RequiredModel model(String model) {
        return new Car.Builder(model);
    }

    public interface RequiredModel {
        RequiredMake make(String make);
    }

    public interface RequiredMake {
        RequiredYear year(String year);
    }

    public interface RequiredYear {
        RequiredColour colour(String colour);
    }

    public interface RequiredColour {
        OptionalAircon aircon(boolean aircon);
        Car build();
    }

    public interface OptionalAircon {
        Car build();
    }

    private static class Builder implements RequiredModel, RequiredMake, RequiredYear, RequiredColour, OptionalAircon {
        private final Car instance = new Car();

        public Builder(String model) {
            instance.model = model;
        }
        @Override
        public RequiredMake make(String make) {
            instance.make = make;
            return this;
        }
        @Override
        public RequiredYear year(String year) {
            instance.year = year;
            return this;
        }
        @Override
        public RequiredColour colour(String colour) {
            instance.colour = colour;
            return this;
        }
        @Override
        public OptionalAircon aircon(boolean aircon) {
            instance.hasAircon = aircon;
            return this;
        }
        @Override
        public Car build() {
            return instance;
        }
    }
}
import java.lang.String;

/**
 * Example of the Builder pattern
 */
public class BuilderPattern {

    /**
     * Our Dog class
     */
    static interface Dog {
        /**
         * Get the Dog's name
         * @return the name of the Dog
         */
        public String getName();
    }

    /**
     * Simple implementation of our Dog
     */
    static class DogImpl implements Dog{
        private final String name;

        public DogImpl(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * The builder - creates a Dog for us
     */
    static class DogBuilder {
        private String name;

        static DogBuilder getBuilder() {
            return new DogBuilder();
        }

        DogBuilder withName(final String name) {
            this.name = name;
            return this;
        }

        Dog complete() {
            return new DogImpl(name);
        }
    }

    public static void main(String[] args) {
        // Example Usage of our builder
        Dog myDog = DogBuilder.getBuilder().withName("Rex").complete();
        System.out.println(myDog.getName());
    }

}
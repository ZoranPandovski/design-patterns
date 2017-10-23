
// An instance of ImmutableBuilder is created using its nested internal Builder
// Each instance can only be created using the Builder
// and cannot have its fields altered!
class ImmutableBuilder {

    private String name;
    private int id;

    // We privatize the constructor to prevent Immutable Builder
    // from being created without using our Builder
    private ImmutableBuilder() {}

    // Constructor can only be used with our builder pattern!
    public ImmutableBuilder(Builder builder) {
        this.name = builder.getName();
        this.id = builder.getId();
    }

    // Nested builder class used for construction of ImmutableBuilder instances
    public static class Builder {

        private String name;
        private int id;

        // Build our instance!
        public ImmutableBuilder build() {
            return new ImmutableBuilder(this);
        }

        // Getter methods
        public String getName() { return name; }

        public int getId() { return id; }

        // Set methods using builder: we return the builder. 
        // This enables our Builder to be 'fluent'
        // and chain our method calls!
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

    }

    public String getName() { return name; }

    public int getId() { return id; }

}

public class ImmutableBuilderEx {

    public static void main(String[] args) {

        ImmutableBuilder instance = new ImmutableBuilder.Builder().setName("Name!").setId(1).build();
        
        System.out.println("Instance name: " + instance.getName() + "\nInstance id: " + instance.getId());

    }

}
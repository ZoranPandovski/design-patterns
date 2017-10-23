class User {

    private final String name;
    private final Mediator mediator;

    // Construct our User instance
    // Pass in our mediator that was created previously!
    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return this.name;
    }

    // Ping the mediator we created
    // Each instance of user will their own name to our mediator
    // We can do the ping without User knowing about Mediator's ping function implementation
    public void ping(String msg) {
        mediator.ping(name, msg);
    }

}

// Multiple users can use the Mediator's ping impl uniquely
// All the same instance of mediator being used
class Mediator {

    public void ping(String name, String msg) {
        System.out.println("User " + name + ": " + msg);
    }

}

public class MediatorEx {

    public static void main(String[] args) {

        // Mediator instance
        Mediator mediator = new Mediator();

        // Unique users
        User tom = new User("Tom", mediator);
        User mark = new User("Mark", mediator);

        // Send messages using our users which uses our mediator
        tom.ping("Whats up man?");
        mark.ping("Not much!");
        
    }

}


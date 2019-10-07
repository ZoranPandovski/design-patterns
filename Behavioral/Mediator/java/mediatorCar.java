class Cars {

    private final String name;
    private final Mediator mediator;

    public Cars(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return this.name;
    }
    public void ping(String pesan) {
        mediator.ping(name, pesan);
    }

}

class Mediator {
    public void ping(String name, String pesan) {
        System.out.println("Cars " + name + ": " + pesan);
    }

}

public class mediatorCar {

    public static void main(String[] args) {        
        Mediator mediator = new Mediator();

        Cars civic = new Cars("Civic", mediator);
        Cars evo = new Cars("Evo-x", mediator);

        civic.ping("I come with new hatchback");
        evo.ping("Rally art is mine");
        
    }

}

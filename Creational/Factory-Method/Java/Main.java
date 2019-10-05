public class Main {

    public static void main(String[] args) {

        MiPizzeria pizzeria = new MiPizzeria();

        Pizza hawaiana = pizzeria.crearPizza("Hawaiana");
        Pizza peperoni = pizzeria.crearPizza("Peperoni");
        Pizza OrillaRellena = pizzeria.crearPizza("Peperoni orilla rellena");

        System.out.println(peperoni);
        System.out.println(hawaiana);
        System.out.println(OrillaRellena);
    }
}

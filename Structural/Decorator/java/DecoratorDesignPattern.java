public class DecoratorDesignPattern {

    public static void main(String[] args) {
                System.out.println("Espresso + Milk");
        Coffee c=new Milk(new Espresso());
        System.out.println(c.getDescription());
        System.out.println("Price = "+c.getCost());
        
        System.out.println("\nEspresso + Soy");
        c=new Soy(new Espresso());
        System.out.println(c.getDescription());
        System.out.println("Price = "+c.getCost());
        
        System.out.println("\nEspresso + Milk + Soy");
        c=new Soy(new Milk(new Espresso()));
        System.out.println(c.getDescription());
        System.out.println("Price = "+c.getCost());
    }
    
}

interface Coffee {
    public String getDescription();
    public float getCost();
}

abstract class CondimentDecorator implements Coffee{
    
    protected Coffee coffeeDecorator;
    
    public CondimentDecorator(Coffee coffee){
        coffeeDecorator=coffee;
    }
    
    @Override
    public String getDescription() {
        return coffeeDecorator.getDescription();
    }

    @Override
    public float getCost() {
        return coffeeDecorator.getCost();
    }  
}

class Espresso implements Coffee {
    
     @Override
    public String getDescription() {
        return "This is Espresso";
    }

    @Override
    public float getCost() {
        return 200;
    }
    
}

class HouseBlend implements Coffee {
     
    @Override
    public String getDescription() {
        return "This is HouseBlend";
    }

    @Override
    public float getCost() {
        return 150;
    }
    
}

class Milk extends CondimentDecorator {
    
    
    public Milk(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffeeDecorator.getDescription()+ " with Milk";
    }

    
    @Override
    public float getCost() {
        return (coffeeDecorator.getCost()+80);
    }
}

class Mocha extends CondimentDecorator{
    public Mocha(Coffee coffee){
        super(coffee);        
    }
    
    @Override
    public String getDescription() {
        return coffeeDecorator.getDescription()+ " with Mocha";
    }

    
    @Override
    public float getCost() {
        return (coffeeDecorator.getCost()+60);
    }
}

class Soy extends CondimentDecorator {
     public Soy(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffeeDecorator.getDescription()+ " with Soy";
    }

    
    public float getCost() {
        return (coffeeDecorator.getCost()+40);
    }
}

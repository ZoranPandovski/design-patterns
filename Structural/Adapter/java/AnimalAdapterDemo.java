
/**
 * Created by trustgeek on 10/17/2017 {11:08 PM}.
 */
interface Animal {
    void action(int forelimbs, int hindlimbs, String act);
}

class Bird {
    void action(int forelimbs, int hindlimbs, String act) {
        System.out.println("I have " + forelimbs + " forelimbs and " + hindlimbs + " hindlimbs. I can "+ act);
    }
}

class Human {
    void action(int forelimbs, int hindlimbs, String act) {
        System.out.println("I have " + forelimbs + " forelimbs and " + hindlimbs + " hindlimbs. I can "+ act);
    }
}

class BirdAdapter implements Animal {
    private Bird adaptee;

    BirdAdapter(Bird dog) {
        this.adaptee = dog;
    }

    @Override
    public void action(int forelimbs, int hindlimbs, String act) {
        String actionAct = act + " to fly" ;
        adaptee.action(forelimbs, hindlimbs, actionAct);
    }
}

class HumanAdapter implements Animal {
    private Human adaptee;

    HumanAdapter(Human human) {
        this.adaptee = human;
    }

    @Override
    public void action(int forelimbs, int hindlimbs, String act) {
        String actionAct = act + " to run";
        adaptee.action(forelimbs, hindlimbs, actionAct);
    }
}

public class AdapterDemo2 {
    public static void main(String[] args) {
        Animal[] animals = {new HumanAdapter(new Human()),
                new BirdAdapter(new Bird())};
        int forelimbs = 2, hindlimbs = 2;
        String act = "move";
        for (Animal animal: animals) {
            animal.action(forelimbs, hindlimbs, act);
        }
    }
}
import java.util.ArrayList;
import java.util.List;

interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}

interface Observer {
    public void update(boolean inStock);
}

class Dress implements Subject {

    private List<Observer> observers;
    private boolean inStock = false;
    private final Object MONITOR = new Object();

    public Dress() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        if (observers == null) {
            return;
        }
        synchronized (MONITOR) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (observers == null) {
            return;
        }
        synchronized (MONITOR) {
            observers.remove(o);
        }
    }

    public void notifyObserver() {
        synchronized (MONITOR) {
            for (Observer obs : observers) {
                obs.update(inStock);
            }
        }
    }

    public void inStock(boolean inStock) {
        this.inStock = inStock;
        notifyObserver();
    }
}

class User implements Observer {

    private Dress d;
    private boolean isinStock;
    private final Object MONITOR = new Object();

    public User(Dress d) {
        this.d = d;
        d.registerObserver(this);
    }

    public void update(boolean inStock) {
        if (isinStock == false) {
            return;
        }
        synchronized (MONITOR) {
            this.isinStock = inStock;

            if (inStock == true) {
                display();
            }
        }
    }

    public void display() {
        System.out.println("Dress back in Stock");
    }
}

public class ObserverConcurrencyDemo {
    public static void main(String[] args) {
        Dress dress = new Dress();
        User anne = new User(dress);
        dress.inStock(true);

        Runnable runnable = () -> {
            User anne2 = new User(dress);
            dress.inStock(true);
        };
        
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
